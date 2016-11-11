package com.hyperion.metadata;


import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()

public class DocumentFindTest {

    @Autowired
    PCDocumentRepository pCDocumentRepository;

    @Test
    public void findDocument(){
        List<PCDocumentModel> documents =
                pCDocumentRepository.findByUserPolicy("NVPA0010010040");
        System.out.println("<<< DOCUMENT DETAILS >>>"+documents.size());

    }
}
