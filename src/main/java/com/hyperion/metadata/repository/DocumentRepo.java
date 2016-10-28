package com.hyperion.metadata.repository;

import com.hyperion.metadata.model.DocumentOnBaseModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "onbase", path="onbase")
public interface DocumentRepo extends MongoRepository<DocumentOnBaseModel,Long> {
    public List<DocumentOnBaseModel> findByAccountId(@Param("accountId") String accountId);
}
