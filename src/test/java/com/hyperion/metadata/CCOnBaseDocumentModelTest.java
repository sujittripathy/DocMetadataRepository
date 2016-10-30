package com.hyperion.metadata;

import com.hyperion.metadata.model.CCDocumentModel;
import com.hyperion.metadata.repository.CC_DocumentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CCOnBaseDocumentModelTest {

    @Autowired
    CC_DocumentRepo cc_documentRepo;

    @Test
    public void addCCDocumentMetadata(){
        int i = 1000000000;
        Random random=new Random();
        do{

            CCDocumentModel doc = new CCDocumentModel();
            doc.setDocID(random.nextInt(Integer.MAX_VALUE)+1);
            doc.setClaimNumber("NVPA-"+i);
            doc.setAuthor("SYSTEM");
            doc.setDocumenttype("other");
            doc.setDocumenttypegroup("other");
            doc.setMimetype("application/pdf");
            doc.setName("CLAIMS FORM - "+i);
            doc.setCreatedDate(new Date());
            doc.setModifiedDate(new Date());
            doc.setSource("CC");
            doc.setGuidEnvelopeId(UUID.randomUUID().toString());

            cc_documentRepo.save(doc);
            System.out.println("CC Document Added Successfully: "+i);
            i++;
        }while(i<=1000000001);

    }
}
