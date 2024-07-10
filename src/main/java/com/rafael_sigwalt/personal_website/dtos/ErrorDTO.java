package com.rafael_sigwalt.personal_website.dtos;


import java.time.LocalDate;

public class ErrorDTO {
    private long timestamp;
    private int status;
    private String error;
    private String path;

    public ErrorDTO( int status, String error, String path) {
        timestamp = System.currentTimeMillis();
        this.status = status;
        this.error = error;
        this.path = path;
    }
}
