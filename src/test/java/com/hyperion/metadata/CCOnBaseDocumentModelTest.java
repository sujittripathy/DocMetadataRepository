package com.hyperion.metadata;

import com.hyperion.metadata.model.PC_BC_DocumentModel;
import com.hyperion.metadata.repository.PC_BC_DocumentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CCOnBaseDocumentModelTest {

    @Autowired
    PC_BC_DocumentRepo documentRepo;

    @Test
    public void addDocumentMetadata(){
        int i = 1000000000;
        do{

            System.out.println("Document Added Successfully: "+i);
            i++;
        }while(i<=1000000001);

    }
}
