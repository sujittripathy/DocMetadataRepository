package com.hyperion.metadata.restclient.policy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class RestClientTestMock {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void test(){
       String response =
               testRestTemplate
                       .withBasicAuth("user","password")
                       .getForObject("/pc/search/document/{polnum}",String.class,"NVPA001000019");
        assertThat(response).contains("1b563ad9-3d76-44cc-bf91-3c224bbdf6ef");
        System.out.println(response);
    }
}
