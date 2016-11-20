package com.hyperion.metadata.restclient.policy;

import com.hyperion.metadata.controller.DocumentTestController;
import com.hyperion.metadata.service.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {DocumentTestController.class})
public class DocumentTestControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private DocumentService documentService;

    @Test
    public void testController() throws Exception{
        given(this.documentService.serviceTestMethod())
                .willReturn("Hello Test");
        this.mvc.perform(get("/pc/home").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Test"));
        this.mvc.perform(get("/pc/home").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Test"));
        verify(documentService,atLeastOnce()).serviceTestMethod();
    }
}
