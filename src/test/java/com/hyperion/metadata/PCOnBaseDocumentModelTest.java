package com.hyperion.metadata;

import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentRepository;
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
public class PCOnBaseDocumentModelTest {

    @Autowired
    PCDocumentRepository documentRepo;

    @Test
    public void addDocumentMetadata(){
        int i = 1000000000;
        Random random=new Random();
        do{
           PCDocumentModel doc = new PCDocumentModel();
            doc.setDocID(random.nextInt(Integer.MAX_VALUE)+1);
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
            doc.setSource("PC");
            doc.setGuidEnvelopeId(UUID.randomUUID().toString());
            doc.setBatchId(random.nextInt(9999));

            documentRepo.save(doc);
            System.out.println("Document Added Successfully: "+i);
            i++;
        }while(i<=1000001000);

    }
}
