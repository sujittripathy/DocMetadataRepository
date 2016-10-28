package com.hyperion.metadata.repository;

import com.hyperion.metadata.model.DocumentOnBaseModel;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepo extends CrudRepository<DocumentOnBaseModel,Long>{
}
