package com.hyperion.metadata.repository;

import com.hyperion.metadata.model.PC_BC_DocumentModel;

import java.util.List;

public interface DocumentRepositoryCustom {
    List<PC_BC_DocumentModel> findDocumentByType(String type);
}
