package com.hyperion.metadata.repository;

import com.hyperion.metadata.model.PCDocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "policy", path="onbase")
public interface PCDocumentRepository extends MongoRepository<PCDocumentModel,Integer> {
    List<PCDocumentModel> findByAccountId(@Param("accountId") String accountId);

    List<PCDocumentModel> findBySource(String s);

    PCDocumentModel findByGuidEnvelopeId(String s);
}
