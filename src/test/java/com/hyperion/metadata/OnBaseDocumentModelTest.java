package com.hyperion.metadata;

import com.hyperion.metadata.model.DocumentOnBaseModel;
import com.hyperion.metadata.repository.DocumentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Random;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnBaseDocumentModelTest {

    @Autowired
    DocumentRepo documentRepo;

    @Test
    public void addDocumentMetadata(){
        int i = 1000000000;
        do{
           DocumentOnBaseModel doc = new DocumentOnBaseModel();
            doc.setDocID(new Random().nextLong());
            doc.setAccountNumber("A"+i);
            doc.setAccountId("pc:"+i);
            doc.setPolicyNumber("NVPA00"+i);
            doc.setPolicyPeriodId("pc:1"+i);
            doc.setAuthor("SYSTEM");
            doc.setDocumenttype("other");
            doc.setDocumenttypegroup("other");
            doc.setMimetype("application/pdf");
            doc.setName("APPLICATION FORM - "+i);
            doc.setCreatedDate(new Date());
            doc.setModifiedDate(new Date());
            doc.setSecuritytype("UNRESTRICTED");
            doc.setContacts(new String[]{"allan","john","kasich"});

            documentRepo.save(doc);
            System.out.println("Document Added Successfully: "+i);
            i++;
        }while(i<=1000000001);

    }
}
