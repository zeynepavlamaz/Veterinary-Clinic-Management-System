package dev.patika.Vet.App.controller;

import dev.patika.Vet.App.business.abs.IAnimalService;
import dev.patika.Vet.App.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    private IAnimalService animalService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findAll(){
        return this.animalService.findAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getById(@PathVariable("id") int id){
        return this.animalService.getByID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody Animal animal){
        return this.animalService.save(animal);
    }



    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Animal update(@RequestBody Animal animal){
        return animalService.save(animal);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        return this.animalService.delete((int) id);
    }


}
