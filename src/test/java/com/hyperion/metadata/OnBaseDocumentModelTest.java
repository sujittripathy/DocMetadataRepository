package com.hyperion.metadata;

import com.hyperion.metadata.model.DocumentOnBaseModel;
import com.hyperion.metadata.repository.DocumentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnBaseDocumentModelTest {

    @Autowired
    DocumentRepo documentRepo;

    @Test
    public void addDocumentMetadata(){
        DocumentOnBaseModel doc = new DocumentOnBaseModel();
        doc.setAccountId("pc:1234");
        doc.setAccountNumber("A12345678");
        doc.setPolicyNumber("NVPA000000098");
        doc.setPolicyPeriodId("pc:8979");
        doc.setCreatedDate(new Date());
        doc.setModifiedDate(new Date());

        documentRepo.save(doc);
        System.out.println("Document Added Successfully:)");
    }
}
