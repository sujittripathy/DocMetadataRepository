package com.hyperion.metadata.repository;

import com.hyperion.metadata.model.CCDocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "onbase/claims", path="onbase/claims")
public interface CC_DocumentRepo extends MongoRepository<CCDocumentModel,Integer> {
}
