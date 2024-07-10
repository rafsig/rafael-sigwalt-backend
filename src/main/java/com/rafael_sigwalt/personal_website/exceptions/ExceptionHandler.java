package com.rafael_sigwalt.personal_website.exceptions;

import com.rafael_sigwalt.personal_website.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.FileNotFoundException;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DataFileNotAccessibleException.class)
    public ResponseEntity<ErrorDTO> dataFileNotFoundException() {
        return ResponseEntity
                .internalServerError()
                .body( new ErrorDTO(
                        500,
                        "File not accessible",
                        ""));
    }
}
