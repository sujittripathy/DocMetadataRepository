package com.hyperion.metadata.model;

import org.springframework.hateoas.Resource;

public class PCDocumentModelResource extends Resource<PCDocumentModel>{

    public PCDocumentModelResource(PCDocumentModel documentModel) {
        super(documentModel);
    }
}
