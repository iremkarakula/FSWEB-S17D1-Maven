package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {
    Map<Integer, Animal> animals ;





    @PostConstruct
    public void loadAll(){
        this.animals = new HashMap<>();
        animals.put(1, new Animal(1, "maymun"));
    }

    @GetMapping
    public List<Animal> getValues(){
        List<Animal> values = new ArrayList<>(animals.values());
        return values;
    }
    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id){
        Animal animal = animals.get(id);
        return animal;
    }
    @PostMapping
    public Map<Integer, Animal> postAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
        return animals;
    }
    @PutMapping("/{id}")
    public Animal putAnimal(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id, animal);
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Animal animal = animals.get(id);
        animals.remove(animal);

    }
}


