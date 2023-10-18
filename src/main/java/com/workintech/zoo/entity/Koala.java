package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Koala {
    private int id;
    private String name; 
    private double weight;
    private String sleepHour;
    private String gender;
}
