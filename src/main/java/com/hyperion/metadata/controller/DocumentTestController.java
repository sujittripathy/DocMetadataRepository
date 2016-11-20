package com.hyperion.metadata.controller;

import com.hyperion.metadata.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DocumentTestController {
    @Autowired
    DocumentService service;

    @RequestMapping(value = "/pc/home", method = RequestMethod.GET)
    @ResponseBody
    public String getHome(){
        return service.serviceTestMethod();
    }
}
