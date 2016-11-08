package com.hyperion.metadata.restcontroller;

import com.hyperion.metadata.response.DocumentResponse;
import com.hyperion.metadata.dto.PolicyDocumentsDTO;
import com.hyperion.metadata.exception.NoDocsFoundException;
import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PCRestController {
    @Autowired
    private PCDocumentRepository pCDocumentRepository;
    @Autowired
    private DocumentResponse documentResponseObj;
    @Autowired
    private ModelMapper modelMapper;

    /*@Bean
    public DocumentResponse documentResponseObj(){
        return new DocumentResponse();
    }

    @Bean
    public DocumentResponse documentResponseObj1(){
        return new DocumentResponse();
    }*/
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    private static final Logger logger = LoggerFactory.getLogger(PCRestController.class);

    @RequestMapping(value = "/pc/add/document",
                    method = RequestMethod.POST)
    public ResponseEntity<?> addNewDocument(@RequestBody PCDocumentModel document) {
        DocumentResponse docResponse = null;
        HttpStatus status=HttpStatus.OK;

        PCDocumentModel doc = pCDocumentRepository.insert(document);
        if(document!=null){
            docResponse
                    = new DocumentResponse();
            docResponse.setCode(200);
            docResponse.setMessage("Document inserted successfully : "
                    +document.getGuidEnvelopeId());
            status = HttpStatus.CREATED;
        }else{
            docResponse
                    = new DocumentResponse();
            docResponse.setCode(406);
            docResponse.setMessage("!! Document insertion failed !! "
                    +document.getGuidEnvelopeId());
            status = HttpStatus.NOT_ACCEPTABLE;
        }
        return new ResponseEntity<DocumentResponse>(docResponse,status);
    }

    @RequestMapping(value = "/pc/delete/document/{guid}", method = RequestMethod.DELETE)
    public ResponseEntity<DocumentResponse> deleteDocument(@PathVariable String guid){
        PCDocumentModel doc = pCDocumentRepository.findByGuidEnvelopeId(guid);
        if(doc!=null){
            pCDocumentRepository.delete(doc);
            documentResponseObj.setCode(0);
            documentResponseObj.setMessage("Deleted Successfully");
            return new ResponseEntity<DocumentResponse>(documentResponseObj,
                    HttpStatus.OK);
        }else{
            documentResponseObj.setCode(1);
            documentResponseObj.setMessage("Not Found/Deleted");
            return new ResponseEntity<DocumentResponse>(documentResponseObj,
                    HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/pc/search/document/{policy}",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE}
                    )
    public @ResponseBody List<PolicyDocumentsDTO> findDocuments(@PathVariable String policy){
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

    @RequestMapping(value = {"/pc/search/document/all","/pc/search/document/findall"},
                    method = RequestMethod.GET)
    public ResponseEntity<List<PCDocumentModel>> findAllDocuments(){
        List<PCDocumentModel> documents = pCDocumentRepository.findAll();
        //////// JUST For Header Test //////
        HttpHeaders header=new HttpHeaders();
        URI loc= URI.create("https://www.google.com");
        header.setLocation(loc);
        List<String> l = new ArrayList<String>();
        l.add("hello");
        l.add("world!");
        header.put("test",l);
        //////// JUST For Test //////
        return new ResponseEntity<List<PCDocumentModel>>(documents,header,HttpStatus.OK);
    }

    @RequestMapping(value = "/pc/update/document", method = RequestMethod.PUT)
    public ResponseEntity<DocumentResponse> updateDocMetadata(@RequestBody PCDocumentModel document){
        System.out.println("PCDocumentModel Details -- "+document);
        PCDocumentModel model = pCDocumentRepository.save(document);
        documentResponseObj.setCode(100);
        documentResponseObj.setMessage("Updated Successfully");
        return new ResponseEntity<DocumentResponse>(documentResponseObj,HttpStatus.OK);
    }

    @ExceptionHandler(value = {NoDocsFoundException.class})
    public ResponseEntity<DocumentResponse> documentNotFound(NoDocsFoundException ndf){
        documentResponseObj.setCode(999);
        documentResponseObj.setMessage("No Documents Found"+ndf.getIdentifier());
        return new ResponseEntity<DocumentResponse>
                    (documentResponseObj,HttpStatus.NOT_FOUND);
    }
}
