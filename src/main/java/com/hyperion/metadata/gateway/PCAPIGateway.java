package com.hyperion.metadata.gateway;

import com.hyperion.metadata.DocumentResponse;
import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
public class PCAPIGateway{
    @Autowired
    private PCDocumentRepository pCDocumentRepository;

    private static final Logger logger = LoggerFactory.getLogger(PCAPIGateway.class);


    public PCDocumentModel addPCDocument(PCDocumentModel pCDocumentModel){
        logger.debug("Received add Document JSON request : "+pCDocumentModel);
        PCDocumentModel doc = pCDocumentRepository.insert(pCDocumentModel);
        return doc;

    }

    public boolean deleteDocument(String guidEnvelopeId){
        PCDocumentModel doc =
                pCDocumentRepository.findByGuidEnvelopeId(guidEnvelopeId);
        if(doc!=null){
            pCDocumentRepository.delete(doc);
            return true;
        }else{
            return false;
        }
    }
}
