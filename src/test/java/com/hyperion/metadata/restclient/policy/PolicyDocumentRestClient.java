package com.hyperion.metadata.restclient.policy;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.response.DocumentResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PolicyDocumentRestClient {

    //@Autowired
    //private RestTemplate restTemplate;

    /*@Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }*/
   // @Test
    public void findPolicyDocument(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/pc/search/document/{polnum}";
        ResponseEntity<String> response =
                    restTemplate.getForEntity(url,String.class,"NVPA001000000");
        Assert.isTrue(response.getStatusCode()== HttpStatus.OK,"!! Assertion Failed !!");

        System.out.println(response.getStatusCode()+","+response.getBody());
        System.out.println(response.getHeaders());

    }

    //@Test
    public void insertPolicyDocument() throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/pc/add/document";
        int i = 109;

        Random random = new Random();
        PCDocumentModel doc = new PCDocumentModel();
        doc.setDocID(random.nextInt(Integer.MAX_VALUE)+1);
        doc.setAccountNumber("A"+i);
        doc.setAccountId("pc:"+i);
        doc.setActivity("pca:"+i);
        doc.setAuthor("SYSTEM");
        doc.setDocumentType("other");
        doc.setMimetype("application/pdf");
        doc.setName("APPLICATION FORM - "+i);
        doc.setJob("pc:"+(i*2));
        doc.setPolicy("pc:"+(i*3));
        doc.setPolicyNumber("NVPA00"+i);
        doc.setPolicyperiod("pc:1"+i);
        doc.setSecuritytype("UNRESTRICTED");
        doc.setCreatedDateTime(new Date());
        doc.setModifiedDateTime(new Date());
        doc.setSource("PC");
        UUID uuid=UUID.randomUUID();
        doc.setGuidEnvelopeId(uuid.toString());
        doc.setUniqueid(uuid.toString());
        doc.setBatchNumber(i*5);
        doc.setDescription("DESC - "+i);
        doc.setObsolete(i%2==0?true:false);
        doc.setCustomerID("CUST"+i);
        doc.setEprDocumentType(i%2==0?"DEC":"ID");
        doc.setPrintsuppression(i%2==0?true:false);
        doc.setSpoolID("SPOOL"+i);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(doc);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity httpEntity = new HttpEntity(jsonString,headers);
        DocumentResponse response = restTemplate.postForObject(url,httpEntity, DocumentResponse.class);
        System.out.println(response.getCode()+","+response.getMessage());
    }

    @Test
    public void deleteDocument(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/pc/delete/document/{guidEnvelopeId}";
        restTemplate.delete(url,"a323a8a9-2a8a-4e76-b8d8-1159b0dd046f");
    }
}
