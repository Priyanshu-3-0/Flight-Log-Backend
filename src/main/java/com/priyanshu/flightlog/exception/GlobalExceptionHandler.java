package com.priyanshu.flightlog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<?> handleFileUploadException(
            FileUploadException exception
    ){

        Map<String,Object> error = new HashMap<>();

        error.put("time", LocalDateTime.now());
        error.put("message", exception.getMessage());
        error.put("status", "FAILED");


        return new ResponseEntity<>(
                error,
                HttpStatus.INTERNAL_SERVER_ERROR
        );

    }



    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(
            RuntimeException exception
    ){

        Map<String,Object> error = new HashMap<>();

        error.put("message", exception.getMessage());
        error.put("status", "FAILED");


        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );

    }

}