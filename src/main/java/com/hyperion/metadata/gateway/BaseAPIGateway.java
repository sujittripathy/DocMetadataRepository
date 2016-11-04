package com.hyperion.metadata.gateway;

import com.hyperion.metadata.model.PCDocumentModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface BaseAPIGateway {
    ResponseEntity<?> addNewDocument(@RequestBody PCDocumentModel document, @RequestParam String param);
}
