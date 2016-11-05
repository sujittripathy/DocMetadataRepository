package com.hyperion.metadata.exception;

public class NoDocsFoundException extends RuntimeException{
    private String identifier;

    public NoDocsFoundException(String i){
        this.identifier = i;
    }

    public String getIdentifier() {
        return identifier;
    }
}
