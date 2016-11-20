package com.hyperion.metadata.restcontroller.search;

import com.fasterxml.jackson.annotation.JsonView;
import com.hyperion.metadata.dto.PolicyDocumentsDTO;
import com.hyperion.metadata.exception.NoDocsFoundException;
import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.model.PCDocumentModelResource;
import com.hyperion.metadata.model.View;
import com.hyperion.metadata.repository.PCDocumentRepository;
import com.hyperion.metadata.response.DocumentResponse;
import com.hyperion.metadata.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController()
@RequestMapping("/pc")
public class PCRestSearchController {
    private static final Logger logger = LoggerFactory.getLogger(PCRestSearchController.class);

    @Autowired
    private DocumentResponse documentResponseObj;
    @Autowired
    private PCDocumentRepository pCDocumentRepository;
    @Autowired
    DocumentService documentService;
    @Autowired
    private ModelMapper modelMapper;


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @RequestMapping(value = "/search/document/{policy}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody
    List<PolicyDocumentsDTO> findDocuments(@PathVariable String policy){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //Custom Implementation with Query
        List<PCDocumentModel> documents = pCDocumentRepository.findByUserPolicy(policy);
        stopWatch.stop();
        System.out.println("Total Time Taken to fetch policy via REST : "+stopWatch.getTotalTimeMillis());
        if(documents.size()==0) {
            throw new NoDocsFoundException(policy);
        }
        List<PolicyDocumentsDTO> policyDocumentsDTOs = new ArrayList<>();
        documents.forEach(document -> {
            PolicyDocumentsDTO dest = modelMapper.map(document,PolicyDocumentsDTO.class);
            policyDocumentsDTOs.add(dest);
        });
        return policyDocumentsDTOs;
    }

    @RequestMapping(value = {"/search/document/all","/pc/search/document/findall"},
                    method = RequestMethod.GET)
    public ResponseEntity<List<PolicyDocumentsDTO>> findAllDocuments(Pageable pageable){
        Page<PCDocumentModel> documents = pCDocumentRepository.findAll(pageable);
        List<PolicyDocumentsDTO> policyDocumentsDTOs = new ArrayList<>();
        documents.forEach(document -> {
            PolicyDocumentsDTO dest = modelMapper.map(document,PolicyDocumentsDTO.class);
            policyDocumentsDTOs.add(dest);
        });
        //////// JUST For Header Test //////
        HttpHeaders header=new HttpHeaders();
        URI loc= URI.create("https://www.google.com");
        header.setLocation(loc);
        List<String> l = new ArrayList<String>();
        l.add("hello");
        l.add("world!");
        header.put("test",l);
        //////// JUST For Test //////
        return new ResponseEntity<List<PolicyDocumentsDTO>>(policyDocumentsDTOs,header, HttpStatus.OK);
    }

    @JsonView(View.Summary.class)
    @RequestMapping(value = "/search/get/all", method = RequestMethod.GET)
    public Page<PCDocumentModel> getAllDocuments(Pageable pageable){
        Page<PCDocumentModel> documents = pCDocumentRepository.findAll(pageable);
        return documents;
    }

    ///////////// ************** [HATEOS URL]   /////////////////
    @RequestMapping(value = "/search/get/document/{guid}", method = RequestMethod.GET)
    public PCDocumentModelResource findDocumentByGUID(@PathVariable String guid){
        PCDocumentModel document = documentService.findDocumentByGUID(guid);
        PCDocumentModelResource resource = new PCDocumentModelResource(document);
        resource.add(linkTo(methodOn(PCRestSearchController.class).
                findDocumentByGUID(guid)).withSelfRel());
        resource.add(linkTo(methodOn(PCRestSearchController.class).
                findAllDocuments()).withRel("all-document"));
        return resource;
    }
    @RequestMapping(value = "/search/get/document/all", method = RequestMethod.GET)
    public List<PCDocumentModelResource> findAllDocuments(){
        List<PCDocumentModel> documentList = pCDocumentRepository.findAll();
        List<PCDocumentModelResource> resourceList = new ArrayList<>();
        documentList.forEach(document -> {
            PCDocumentModelResource resource = new PCDocumentModelResource(document);
            resource.add(linkTo(methodOn(PCRestSearchController.class).
                                findDocumentByGUID(document.getGuidEnvelopeId())).withSelfRel());
            resource.add(linkTo(methodOn(PCRestSearchController.class).
                                findAllDocuments()).withRel("all-document"));
            resourceList.add(resource);
        });
        return resourceList;
    }
    ///////////// **************    /////////////////

    @ExceptionHandler(value = {NoDocsFoundException.class})
    public ResponseEntity<DocumentResponse> documentNotFound(NoDocsFoundException ndf){
        documentResponseObj.setCode(999);
        documentResponseObj.setMessage("No Documents Found"+ndf.getIdentifier());
        return new ResponseEntity<DocumentResponse>
                (documentResponseObj,HttpStatus.NOT_FOUND);
    }
}
