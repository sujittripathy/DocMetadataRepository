package com.hyperion.metadata.controller;

import com.hyperion.metadata.DocumentResponse;
import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.BCDocumentRepository;
import com.hyperion.metadata.repository.CCDocumentRepository;
import com.hyperion.metadata.repository.PCDocumentCustomRepository;
import com.hyperion.metadata.repository.PCDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OnBaseAPIGateway {

    private static Logger logger = LoggerFactory.getLogger(OnBaseAPIGateway.class);

    @Autowired
    PCDocumentRepository pCDocumentRepository;
    @Autowired
    PCDocumentCustomRepository PCDocumentCustomRepository;
    @Autowired
    BCDocumentRepository bCDocumentRepository;
    @Autowired
    CCDocumentRepository cCDocumentRepository;

    @Autowired
    PCDocumentCustomRepository documentRepositoryCustom;

    // sample - http://localhost:8080/find/PC/999993f4-7fed-4d4b-bcd2-b7169fc1e05a
    @RequestMapping(value = "/find/{source}/{envelopeID}", method = RequestMethod.GET)
    public ResponseEntity<?> findDocumentByEnvelopeId(@PathVariable String source,@PathVariable String envelopeID){
        logger.info("Inside findDocumentByEnvelopeId method,"+source);
        ResponseEntity<?> responseEntity = null;
        switch(source){
            case "PC":
                PCDocumentModel pCDocumentModel = pCDocumentRepository.findByGuidEnvelopeId(envelopeID);
                if(pCDocumentModel == null){
                    DocumentResponse docNotFoundError
                            = new DocumentResponse(404, "Document not found with Envelope id" +envelopeID);
                    responseEntity = new ResponseEntity<DocumentResponse>(docNotFoundError,HttpStatus.NOT_FOUND);
                }else {
                    responseEntity = new ResponseEntity<PCDocumentModel>(pCDocumentModel,HttpStatus.OK);
                }
                break;
            case "BC":
                //BCDocumentModel bcDocumentModel = bCDocumentRepository.find
                break;
            case "CC":
                break;
        }
        logger.debug("findDocumentByEnvelopeId ResponseEntity >>"+responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = "/GetDocsBySource", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<PCDocumentModel> getSourceDocuments(@RequestParam String source){
        System.out.println("Source value : "+source);
        return pCDocumentRepository.findBySource(source);
    }

    @RequestMapping(value = "/GetDocsBySourceType", method = RequestMethod.GET)
    public List<PCDocumentModel> findDocumentByDocType(@RequestParam String source, @RequestParam String type) {
        return documentRepositoryCustom.findDocumentOnCriteria("documenttype",type);
    }

}
