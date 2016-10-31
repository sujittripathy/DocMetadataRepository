package com.hyperion.metadata;


import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DocumentFindTest {

    @Autowired
    PCDocumentRepository pCDocumentRepository;

    @Test
    public void findDocument(){
        PCDocumentModel doc =
                pCDocumentRepository.findByGuidEnvelopeId("999993f4-7fed-4d4b-bcd2-b7169fc1e05a");
        System.out.println("<<< DOCUMENT DETAILS >>>"+doc.getAccountNumber());

    }
}
