package com.workintech.zoo.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.workintech.zoo.entity.Animal;

public class AnimalValidation {

     public static void isIdAvailable(Map<Integer, Animal> animals, int id){
        if(animals.containsKey(id)){
            throw new AnimalException("This id (" + id + ") already exists.", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdValid(int id){
        if(id < 0){
            throw new AnimalException("The id must be a positive integer.", HttpStatus.BAD_REQUEST);
        }
    }
    
    public static void doesIdExist(Map<Integer, Animal> animals, int id){
        if(!animals.containsKey(id)){
            throw new AnimalException("Animal with this id (" + id + ") does not exist.", HttpStatus.NOT_FOUND);
        }
    }
}
