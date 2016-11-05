package com.hyperion.metadata.gateway;

import com.hyperion.metadata.DocumentResponse;
import com.hyperion.metadata.exception.NoDocsFoundException;
import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PCAPIGateway{
    @Autowired
    private PCDocumentRepository pCDocumentRepository;

    private static final Logger logger = LoggerFactory.getLogger(PCAPIGateway.class);

    @RequestMapping(value = "/pc/add/document",
                    method = RequestMethod.POST)
    public ResponseEntity<?> addNewDocument(@RequestBody PCDocumentModel document) {
        DocumentResponse docResponse = null;
        HttpStatus status=HttpStatus.OK;

        PCDocumentModel doc = pCDocumentRepository.insert(document);
        if(document!=null){
            docResponse
                    = new DocumentResponse(200, "Document inserted successfully : "
                    +document.getGuidEnvelopeId());
            status = HttpStatus.CREATED;
        }else{
            docResponse
                    = new DocumentResponse(406, "!! Document insertion failed !! "
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
            return new ResponseEntity<DocumentResponse>(new DocumentResponse(0,"Deleted Successfully"),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<DocumentResponse>(new DocumentResponse(1,"Not Found/Deleted"),
                    HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/pc/search/document/{policy}",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE}
                    )
    public @ResponseBody List<PCDocumentModel> findDocuments(@PathVariable String policy){
        //Custom Implementation with Query
        List<PCDocumentModel> documents = pCDocumentRepository.findByUserPolicy(policy);
        if(documents.size()==0) {
                throw new NoDocsFoundException(policy);
        }
        return documents;
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
        return new ResponseEntity<DocumentResponse>(new DocumentResponse(100,"Updated Successfully"),HttpStatus.OK);
    }

    @ExceptionHandler(value = {NoDocsFoundException.class})
    public ResponseEntity<DocumentResponse> documentNotFound(NoDocsFoundException ndf){
        return new ResponseEntity<DocumentResponse>
                    (new DocumentResponse(999,"No Documents Found"+ndf.getIdentifier()),HttpStatus.NOT_FOUND);
    }
}
