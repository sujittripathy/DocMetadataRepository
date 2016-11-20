package com.hyperion.metadata.controller;

import com.hyperion.metadata.dto.PolicyDocumentsDTO;
import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import com.hyperion.metadata.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PCController {

    @Autowired
    PCDocumentRepository pCDocumentRepository;

    /*@RequestMapping(value = "/pc/search/document/all/html",
                    method = RequestMethod.GET)
    public String findAllDocuments(Model model){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<PCDocumentModel> documents = pCDocumentRepository.findAll();
        stopWatch.stop();
        List<PolicyDocumentsDTO> filterDocuments = new ArrayList<>();
        documents.forEach(document -> {
            PolicyDocumentsDTO dest = modelMapper.map(document,PolicyDocumentsDTO.class);
            filterDocuments.add(dest);
        });
        System.out.println("filterDocuments Size :: "+filterDocuments.size()
                    +", Time Taken To Fetch: "+stopWatch.getTotalTimeMillis());
        model.addAttribute("documentCount",filterDocuments.size());
        model.addAttribute("policyDocumentList",filterDocuments);
        return "ViewOnBaseDocuments";
    }*/
    @RequestMapping(value = "/pc/search/document/page/html",
                    method = RequestMethod.GET)
    public String findDocumentsWPaginated(Model model, Pageable pageable){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Page<PCDocumentModel> documents = pCDocumentRepository.findAll(pageable);
        stopWatch.stop();
        model.addAttribute("policyDocumentList",documents);
        return "ViewOnBaseDocuments";
    }

}
