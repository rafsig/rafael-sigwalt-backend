package com.rafael_sigwalt.personal_website.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException() {
        return ResponseEntity
                .internalServerError()
                .body("Resource not found");
    }
}
