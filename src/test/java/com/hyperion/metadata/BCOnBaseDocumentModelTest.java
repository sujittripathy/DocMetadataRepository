package com.hyperion.metadata;

import com.hyperion.metadata.model.BCDocumentModel;
import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.BCDocumentRepository;
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
public class BCOnBaseDocumentModelTest {

    @Autowired
    BCDocumentRepository documentRepo;

    @Test
    public void addDocumentMetadata(){
        int i = 2000004000;
        Random random=new Random();
        do{
           BCDocumentModel doc = new BCDocumentModel();
            doc.setDocID(random.nextInt(Integer.MAX_VALUE)+1);
            doc.setAccountNumber("A"+i);
            doc.setAccountId("bc:"+i);
            doc.setPolicyNumber("NVPA00"+i);
            doc.setPolicyPeriodId("pc:1"+i);
            if(i%2==0){
                doc.setAuthor("SYSTEM");
                doc.setDocumenttype("invoice");
                doc.setDocumenttypegroup("invoice");
            }else{
                doc.setAuthor("ssmith");
                doc.setDocumenttype("payment letter");
                doc.setDocumenttypegroup("other");
            }
            doc.setMimetype("application/pdf");
            doc.setName("APPLICATION BC FORM - "+i);
            doc.setCreatedDate(new Date());
            doc.setModifiedDate(new Date());
            doc.setSecuritytype("UNRESTRICTED");
            doc.setSource("BC");
            doc.setGuidEnvelopeId(UUID.randomUUID().toString());

            documentRepo.save(doc);
            System.out.println("BC Document Added Successfully: "+i);
            i++;
        }while(i<=2000004010);

    }
}
