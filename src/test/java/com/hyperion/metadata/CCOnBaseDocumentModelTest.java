package com.hyperion.metadata;

import com.hyperion.metadata.model.CCDocumentModel;
import com.hyperion.metadata.repository.CCDocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CCOnBaseDocumentModelTest {

    @Autowired
    CCDocumentRepository cc_documentRepo;

    @Test
    public void addCCDocumentMetadata(){
        int i = 1000000000;
        Random random=new Random();
        do{

            CCDocumentModel doc = new CCDocumentModel();
            doc.setDocID(random.nextInt(Integer.MAX_VALUE)+1);
            doc.setClaimNumber("NVPA-"+i);
            doc.setAuthor("SYSTEM");
            if(i%2==0) {
                //doc.setDocumenttype("correspondence");
            }else {
               // doc.setDocumenttype("iso");
            }
            //doc.setDocumenttypegroup("other");
            doc.setMimetype("application/pdf");
            doc.setName("CLAIMS FORM - "+i);
            doc.setCreatedDate(new Date());
            doc.setModifiedDate(new Date());
            doc.setSource("CC");
            doc.setGuidEnvelopeId(UUID.randomUUID().toString());
            doc.setMatter("Matter - "+i);
            HashMap<Integer,String> exposureMap= new HashMap<>();
            exposureMap.put(i,"Exposure ID"+i);
           // CCDocumentModel.Incident c= new CCDocumentModel.Incident(i,"Incident ID"+i,exposureMap);
           // ArrayList<CCDocumentModel.Incident> incidentArrayList = new ArrayList<>();
            //incidentArrayList.add(c);
            //doc.setIncidents(incidentArrayList);
            cc_documentRepo.save(doc);
            System.out.println("CC Document Added Successfully: "+i);
            i++;
        }while(i<=1000000001);

    }
}
