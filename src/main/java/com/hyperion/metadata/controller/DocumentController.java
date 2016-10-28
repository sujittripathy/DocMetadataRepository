package com.hyperion.metadata.controller;

import com.hyperion.metadata.model.DocumentOnBaseModel;
import com.hyperion.metadata.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;
import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    DocumentRepo documentRepo;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDocument(@ModelAttribute DocumentOnBaseModel documentOnBaseModel){
        documentRepo.save(documentOnBaseModel);
        return null;
    }

    @RequestMapping(value="/showMetadata", method = RequestMethod.GET)
    public String viewAllDocument(){
        Iterator<DocumentOnBaseModel> documentList = documentRepo.findAll().iterator();
        return null;
    }
}
