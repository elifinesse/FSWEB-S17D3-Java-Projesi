package com.workintech.zoo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.zoo.entity.Animal;
import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.AnimalValidation;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    Map<Integer, Animal> kangaroos;

    public KangarooController(){
        kangaroos = new HashMap<>();
    }

    @GetMapping("/")
    public List<Animal> getKangaroos(){
        return kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getKangaroo(@PathVariable int id){
        AnimalValidation.doesIdExist(kangaroos, id);
        return kangaroos.get(id);
    }

    @PostMapping("/")
    public Animal postKangaroo(@RequestBody Kangaroo kangaroo){
        AnimalValidation.isIdValid(kangaroo.getId());
        AnimalValidation.isIdAvailable(kangaroos, kangaroo.getId());
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @PutMapping("/{id}")
    public Animal updtaeKangaroo(@PathVariable int id, @RequestBody Kangaroo kangaroo){
        AnimalValidation.doesIdExist(kangaroos, id);
        kangaroos.put(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/{id}")
    public Animal deleteKangaroo(@PathVariable int id){
        AnimalValidation.doesIdExist(kangaroos, id);
        kangaroos.remove(id);
        return kangaroos.get(id);
    }
}
