package com.hyperion.metadata.restclient.policy.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class RestClientTestMock {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void test(){
        this.testRestTemplate.getForEntity("/pc/search/document/{polnum}",String.class,"NVPA0010010040");
    }
}
