package com.example.goodmorning.controller;


import com.example.goodmorning.domain.ErrorResponse;
import com.example.goodmorning.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Object> handleException(GeneralException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleException(HttpClientErrorException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), e.getStatusCode());
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<Object> handleException(HttpServerErrorException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), e.getStatusCode());
    }

    //todo: mapStruct
    //todo: sonar
}
