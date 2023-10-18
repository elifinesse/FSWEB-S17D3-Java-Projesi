package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class AnimalException extends RuntimeException{
    private HttpStatus status;

    public AnimalException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
    
}
