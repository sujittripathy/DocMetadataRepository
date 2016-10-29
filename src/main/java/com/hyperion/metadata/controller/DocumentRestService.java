package com.hyperion.metadata.controller;

import com.hyperion.metadata.model.PC_BC_DocumentModel;
import com.hyperion.metadata.repository.DocumentRepositoryCustom;
import com.hyperion.metadata.repository.PC_BC_DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DocumentRestService {

    @Autowired
    PC_BC_DocumentRepo pcbcRepository;
    @Autowired
    DocumentRepositoryCustom documentRepositoryCustom;

    @RequestMapping(value = "/GetPCDocs", method = RequestMethod.GET)
    public List<PC_BC_DocumentModel> getSourceDocuments(@RequestParam String source){
        System.out.println("Source value : "+source);
        return pcbcRepository.findBySource(source);
    }

    @RequestMapping(value = "/GetDocsByType", method = RequestMethod.GET)
    public List<PC_BC_DocumentModel> findDocumentByDocType(@RequestParam String type){
        return documentRepositoryCustom.findDocumentByType(type);
    }
}
