package dev.patika.Vet.App.controller;


import dev.patika.Vet.App.business.abs.IVaccineService;
import dev.patika.Vet.App.entity.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccines")
public class VaccineController {

    @Autowired
    private IVaccineService vaccinesService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> findAll(){
        return this.vaccinesService.findAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine finByID(@PathVariable("id") int id){
        return this.vaccinesService.getByID(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine save(@RequestBody Vaccine vaccines){
        return this.vaccinesService.save(vaccines);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine update(@RequestBody Vaccine vaccines){
        return vaccinesService.save(vaccines);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        return this.vaccinesService.delete((int) id);
    }
}
