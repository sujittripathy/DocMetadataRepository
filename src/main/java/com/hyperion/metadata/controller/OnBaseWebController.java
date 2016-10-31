package com.hyperion.metadata.controller;

import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;

@Controller
public class OnBaseWebController {

    @Autowired
    PCDocumentRepository documentRepo;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDocument(@ModelAttribute PCDocumentModel documentOnBaseModel){
        documentRepo.save(documentOnBaseModel);
        return null;
    }

    @RequestMapping(value="/showDocuments", method = RequestMethod.GET)
    public String viewAllDocument(){
        Iterator<PCDocumentModel> documentList = documentRepo.findAll().iterator();
        return "ViewOnBaseDocuments";
    }


}
