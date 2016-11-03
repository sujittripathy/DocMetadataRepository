package com.hyperion.metadata.gateway;

import com.hyperion.metadata.DocumentResponse;
import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PCAPIGateway extends BaseAPIGatewayImpl {
    @Autowired
    private PCDocumentRepository pCDocumentRepository;

    private static final Logger logger = LoggerFactory.getLogger(PCAPIGateway.class);

    @RequestMapping(value = "/pc/add", method = RequestMethod.POST)
    public ResponseEntity<DocumentResponse> addDocument(@RequestBody PCDocumentModel pCDocumentModel){
        logger.debug("Received JSON request : "+pCDocumentModel);
        PCDocumentModel doc = pCDocumentRepository.insert(pCDocumentModel);
        DocumentResponse docResponse = null;
        HttpStatus status=null;
        if(doc!=null){
            docResponse
                    = new DocumentResponse(200, "Document inserted successfully : "
                    +pCDocumentModel.getGuidEnvelopeId());
            status = HttpStatus.OK;
        }else{
            docResponse
                    = new DocumentResponse(406, "!! Document insertion failed !! "
                    +pCDocumentModel.getGuidEnvelopeId());
            status = HttpStatus.NOT_ACCEPTABLE;
        }
        logger.debug("Response returned : "+docResponse.getCode() +","+docResponse.getMessage());
        return new ResponseEntity<DocumentResponse>(docResponse,status);
    }
}
