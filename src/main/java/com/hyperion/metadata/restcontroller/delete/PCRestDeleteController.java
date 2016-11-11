package com.hyperion.metadata.restcontroller.delete;

import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import com.hyperion.metadata.response.DocumentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/pc")
public class PCRestDeleteController {
    @Autowired
    private PCDocumentRepository pCDocumentRepository;
    @Autowired
    private DocumentResponse documentResponseObj;

    @RequestMapping(value = "/delete/document/{guid}", method = RequestMethod.DELETE)
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
}
