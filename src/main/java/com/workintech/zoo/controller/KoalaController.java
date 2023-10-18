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

import com.workintech.zoo.entity.Koala;

public class KoalaController {
     Map<Integer, Koala> koalas;

    public KoalaController(){
        koalas = new HashMap<>();
    }

    @GetMapping("/")
    public List<Koala> getKoalas(){
        return koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala getKoala(@PathVariable int id){
        return koalas.get(id);
    }

    @PostMapping("/")
    public Koala postKoala(@RequestBody Koala koala){
        koalas.put(koala.getId(), koala);
        return koala;
    }

    @PutMapping("/{id}")
    public Koala updtaeKoala(@PathVariable int id, @RequestBody Koala koala){
        koalas.put(id, koala);
        return koala;
    }

    @DeleteMapping("/{id}")
    public Koala deleteKoala(@PathVariable int id){
        koalas.remove(id);
        return koalas.get(id);
    }
}
