package com.hyperion.metadata.restcontroller.upload;

import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import com.hyperion.metadata.response.DocumentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pc")
public class PCRestUploadController {
    @Autowired
    private PCDocumentRepository pCDocumentRepository;
    @Autowired
    private DocumentResponse documentResponseObj;

    @RequestMapping(value = "/add/document",
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
}
