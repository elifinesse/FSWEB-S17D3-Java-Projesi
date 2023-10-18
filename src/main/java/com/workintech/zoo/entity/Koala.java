package com.workintech.zoo.entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Koala extends Animal{

    private String sleepHour;

    public Koala(int id, String name, int weight, String gender, String sleepHour) {
        super(id, name, weight, gender);
        this.sleepHour = sleepHour;
    }

    

}
