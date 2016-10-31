package com.hyperion.metadata;

public class DocumentResponse {
    private int code;
    private String message;

    public DocumentResponse(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
