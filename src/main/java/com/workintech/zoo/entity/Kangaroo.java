package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kangaroo {

    private int id;
    private String name;
    private int height;
    private int weight;
    private String gender;
    private boolean isAggressive;

}
