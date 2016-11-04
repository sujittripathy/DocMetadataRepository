package com.hyperion.metadata.gateway;

import com.hyperion.metadata.DocumentResponse;
import com.hyperion.metadata.model.BaseDocumentModel;
import com.hyperion.metadata.model.PCDocumentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BaseAPIGatewayImpl implements BaseAPIGateway {

    @Autowired
    PCAPIGateway pcapiGateway;

    @RequestMapping(value = "/{source}/addDocument", method = RequestMethod.POST)
    @Override
    public ResponseEntity<?> addNewDocument(@RequestBody PCDocumentModel document, @PathVariable String source) {
        DocumentResponse docResponse = null;
        HttpStatus status=HttpStatus.OK;

        switch (source){
            case "pc":
                PCDocumentModel pcDocumentModel = pcapiGateway.addPCDocument((PCDocumentModel) document);
                if(pcDocumentModel!=null){
                    docResponse
                            = new DocumentResponse(200, "Document inserted successfully : "
                            +pcDocumentModel.getGuidEnvelopeId());
                    status = HttpStatus.OK;
                }else{
                    docResponse
                            = new DocumentResponse(406, "!! Document insertion failed !! "
                            +pcDocumentModel.getGuidEnvelopeId());
                    status = HttpStatus.NOT_ACCEPTABLE;
                }
                break;
            default:
                break;
        }
        return new ResponseEntity<DocumentResponse>(docResponse,status);
    }
}
