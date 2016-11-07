package com.hyperion.metadata.controller;

import com.hyperion.metadata.dto.PolicyDocumentsDTO;
import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PCController {

    @Autowired
    PCDocumentRepository pCDocumentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @RequestMapping(value = "/pc/search/document/all/html",
                    method = RequestMethod.GET)
    public String findAllDocuments(Model model){
        PageRequest pr=new PageRequest(2,10);
        List<PCDocumentModel> documents = pCDocumentRepository.findAll();
        List<PolicyDocumentsDTO> filterDocuments = new ArrayList<>();
        documents.forEach(document -> {
            PolicyDocumentsDTO dest = modelMapper.map(document,PolicyDocumentsDTO.class);
            filterDocuments.add(dest);
        });
        System.out.println("filterDocuments Size :: "+filterDocuments.size());
        model.addAttribute("documentCount",filterDocuments.size());
        model.addAttribute("policyDocumentList",filterDocuments);
        return "ViewOnBaseDocuments";
    }
    @RequestMapping(value = "/pc/home",
            method = RequestMethod.GET)
    public String getHome(){
        return "home";
    }
}
