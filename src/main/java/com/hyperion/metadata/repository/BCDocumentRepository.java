package com.hyperion.metadata.repository;

import com.hyperion.metadata.model.BCDocumentModel;
import com.hyperion.metadata.model.PCDocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "billing", path="onbase")
public interface BCDocumentRepository extends MongoRepository<BCDocumentModel,Integer> {

}
