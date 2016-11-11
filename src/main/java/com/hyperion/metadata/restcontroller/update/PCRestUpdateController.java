package com.hyperion.metadata.restcontroller.update;

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
public class PCRestUpdateController {
    @Autowired
    private PCDocumentRepository pCDocumentRepository;
    @Autowired
    private DocumentResponse documentResponseObj;

    @RequestMapping(value = "/update/document", method = RequestMethod.PUT)
    public ResponseEntity<DocumentResponse> updateDocMetadata(@RequestBody PCDocumentModel document){
        System.out.println("PCDocumentModel Details -- "+document);
        PCDocumentModel model = pCDocumentRepository.save(document);
        documentResponseObj.setCode(100);
        documentResponseObj.setMessage("Updated Successfully");
        return new ResponseEntity<DocumentResponse>(documentResponseObj, HttpStatus.OK);
    }
}
