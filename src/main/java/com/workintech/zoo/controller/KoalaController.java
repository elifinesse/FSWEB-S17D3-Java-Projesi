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
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.AnimalValidation;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
     Map<Integer, Animal> koalas;

    public KoalaController(){
        koalas = new HashMap<>();
    }

    @GetMapping("/")
    public List<Animal> getKoalas(){
        return koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getKoala(@PathVariable int id){
        AnimalValidation.doesIdExist(koalas, id);
        return koalas.get(id);
    }

    @PostMapping("/")
    public Koala postKoala(@RequestBody Koala koala){
        AnimalValidation.isIdValid(koala.getId());
        AnimalValidation.isIdAvailable(koalas, koala.getId());
        koalas.put(koala.getId(), koala);
        return koala;
    }

    @PutMapping("/{id}")
    public Koala updtaeKoala(@PathVariable int id, @RequestBody Koala koala){
        AnimalValidation.doesIdExist(koalas, id);
        koalas.put(id, koala);
        return koala;
    }

    @DeleteMapping("/{id}")
    public Animal deleteKoala(@PathVariable int id){
        AnimalValidation.doesIdExist(koalas, id);
        koalas.remove(id);
        return koalas.get(id);
    }
}
