package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Kangaroo extends Animal{

    private String height;
    private boolean isAggressive;

    public Kangaroo(int id, String name, int weight, String gender, String height, boolean isAggressive) {
        super(id, name, weight, gender);
        this.height = height;
        this.isAggressive = isAggressive;
    }
    

}
