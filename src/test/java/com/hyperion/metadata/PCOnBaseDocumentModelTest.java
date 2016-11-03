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
        int i = 1;
        Random random=new Random();
        do{
           PCDocumentModel doc = new PCDocumentModel();
            doc.setDocID(random.nextInt(Integer.MAX_VALUE)+1);
            doc.setAccountNumber("A"+i);
            doc.setAccountId("pc:"+i);
            doc.setActivity("pca:"+i);
            doc.setAuthor("SYSTEM");
            doc.setDocumentType("other");
            doc.setMimetype("application/pdf");
            doc.setName("APPLICATION FORM - "+i);
            doc.setJob("pc:"+(i*2));
            doc.setPolicy("pc:"+(i*3));
            doc.setPolicyNumber("NVPA00"+i);
            doc.setPolicyperiod("pc:1"+i);
            doc.setSecuritytype("UNRESTRICTED");
            doc.setCreatedDateTime(new Date());
            doc.setModifiedDateTime(new Date());
            doc.setSource("PC");
            UUID uuid=UUID.randomUUID();
            doc.setGuidEnvelopeId(uuid.toString());
            doc.setUniqueid(uuid.toString());
            doc.setBatchNumber(i*5);
            doc.setDescription("DESC - "+i);
            doc.setObsolete(i%2==0?true:false);
            doc.setCustomerID("CUST"+i);
            doc.setEprDocumentType(i%2==0?"DEC":"ID");
            doc.setPrintsuppression(i%2==0?true:false);
            doc.setCustomerID("SPOOL"+i);

            documentRepo.save(doc);
            System.out.println("Document Added Successfully: "+i);
            i++;

        }while(i<=2);

    }
}
