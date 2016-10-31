package com.hyperion.metadata.repository;

import com.hyperion.metadata.model.PCDocumentModel;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PCDocumentCustomRepository {
    List<PCDocumentModel> findDocumentOnCriteria(String key,String value);

   // @Query("{ ?0: ?1}")
   // List<PCDocumentModel> findDocBySourceType(String source, String type);
}
