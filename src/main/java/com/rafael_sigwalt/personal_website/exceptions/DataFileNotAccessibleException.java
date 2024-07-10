package com.rafael_sigwalt.personal_website.exceptions;

public class DataFileNotAccessibleException extends RuntimeException{

    public DataFileNotAccessibleException(Exception ex) {
        super(ex);
    }
}
