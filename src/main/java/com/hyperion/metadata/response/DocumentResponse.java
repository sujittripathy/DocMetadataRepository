package com.hyperion.metadata.response;

import org.springframework.stereotype.Component;

@Component
public class DocumentResponse {
    private int code;
    private String message;

    public DocumentResponse(){
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
