package com.rafael_sigwalt.personal_website.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Exception ex) {
        super(ex);
    }
}
