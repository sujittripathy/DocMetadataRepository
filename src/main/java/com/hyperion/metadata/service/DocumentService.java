package com.hyperion.metadata.service;

import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private PCDocumentRepository pCDocumentRepository;

    public String serviceTestMethod(){
        return "Hello Test";
    }

    public PCDocumentModel findDocumentByGUID(String guid){
        return pCDocumentRepository.findByGuidEnvelopeId(guid);
    }
}
