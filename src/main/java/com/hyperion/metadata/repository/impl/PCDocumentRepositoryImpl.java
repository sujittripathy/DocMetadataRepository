package com.hyperion.metadata.repository.impl;

import com.hyperion.metadata.model.PCDocumentModel;
import com.hyperion.metadata.repository.PCDocumentCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

public class PCDocumentRepositoryImpl implements PCDocumentCustomRepository {

    @Autowired
    private MongoOperations mongoOperations;

    public List<PCDocumentModel> findDocumentOnCriteria(String key,String value){
        Criteria criteria = Criteria.where(key).is(value);
        Query query=Query.query(criteria);
        return mongoOperations.find(query,PCDocumentModel.class);
    }

}
