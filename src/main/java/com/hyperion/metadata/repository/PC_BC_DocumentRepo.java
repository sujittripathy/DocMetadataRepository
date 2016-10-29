package com.hyperion.metadata.repository;

import com.hyperion.metadata.model.PC_BC_DocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "onbase", path="onbase")
public interface PC_BC_DocumentRepo extends MongoRepository<PC_BC_DocumentModel,Integer> {
    List<PC_BC_DocumentModel> findByAccountId(@Param("accountId") String accountId);

    @Query("{ ?0: ?1}")
    List<PC_BC_DocumentModel> findDocByAttributes(String key, String value);

    List<PC_BC_DocumentModel> findBySource(String s);

}
