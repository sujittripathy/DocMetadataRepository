package com.hyperion.metadata.controller;

import com.hyperion.metadata.model.PC_BC_DocumentModel;
import com.hyperion.metadata.repository.PC_BC_DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@Controller
public class DocumentController {

    @Autowired
    PC_BC_DocumentRepo documentRepo;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDocument(@ModelAttribute PC_BC_DocumentModel documentOnBaseModel){
        documentRepo.save(documentOnBaseModel);
        return null;
    }

    @RequestMapping(value="/showMetadata", method = RequestMethod.GET)
    public String viewAllDocument(){
        Iterator<PC_BC_DocumentModel> documentList = documentRepo.findAll().iterator();
        return null;
    }


}
