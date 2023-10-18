package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<AnimalErrorResponse> handleAnimalException(AnimalException exception){
        AnimalErrorResponse response = new AnimalErrorResponse(exception.getStatus().value(),  exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<AnimalErrorResponse> handleAnimalException(Exception exception){
        AnimalErrorResponse response = new AnimalErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
