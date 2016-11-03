package com.hyperion.metadata.gateway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseAPIGatewayImpl implements BaseAPIGateway {
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void insertDocument(){

    }
}
