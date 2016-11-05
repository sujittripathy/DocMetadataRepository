package com.hyperion.metadata.restclient.policy;


import com.hyperion.metadata.model.PCDocumentModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PolicyDocumentQuery {

    @Test
    public void findPolicyDocument(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/pc/search/document/{polnum}";
        ResponseEntity<String> response =
                    restTemplate.getForEntity(url,String.class,"NVPA001000000");
        Assert.isTrue(response.getStatusCode()== HttpStatus.OK,"!! Assertion Failed !!");

        System.out.println(response.getStatusCode()+","+response.getBody());
        System.out.println(response.getHeaders());

    }
}
