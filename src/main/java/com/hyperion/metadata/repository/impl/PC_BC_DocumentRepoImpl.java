package com.hyperion.metadata.repository.impl;

import com.hyperion.metadata.model.PC_BC_DocumentModel;
import com.hyperion.metadata.repository.DocumentRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

public class PC_BC_DocumentRepoImpl implements DocumentRepositoryCustom {

    @Autowired
    private MongoOperations mongoOperations;

    public List<PC_BC_DocumentModel> findDocumentByType(String type){
        Criteria criteria = Criteria.where("documenttype").is(type);
        Query query=Query.query(criteria);
        return mongoOperations.find(query,PC_BC_DocumentModel.class);
    }

}
