package com.hyperion.metadata.gateway;

import com.hyperion.metadata.restcontroller.PCRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseAPIGatewayImpl implements BaseAPIGateway {

    @Autowired
    PCRestController pcapiGateway;






}
