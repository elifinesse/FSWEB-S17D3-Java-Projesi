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

import com.workintech.zoo.entity.Kangaroo;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    Map<Integer, Kangaroo> kangaroos;

    public KangarooController(){
        kangaroos = new HashMap<>();
    }

    @GetMapping("/")
    public List<Kangaroo> getKangaroos(){
        return kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo getKangaroo(@PathVariable int id){
        return kangaroos.get(id);
    }

    @PostMapping("/")
    public Kangaroo postKangaroo(@RequestBody Kangaroo kangaroo){
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @PutMapping("/{id}")
    public Kangaroo updtaeKangaroo(@PathVariable int id, @RequestBody Kangaroo kangaroo){
        kangaroos.put(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable int id){
        kangaroos.remove(id);
        return kangaroos.get(id);
    }
}
