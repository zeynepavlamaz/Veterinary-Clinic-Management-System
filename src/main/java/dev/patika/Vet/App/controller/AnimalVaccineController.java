package dev.patika.Vet.App.controller;

import dev.patika.Vet.App.business.abs.IAnimalVaccineService;
import dev.patika.Vet.App.entity.AnimalVaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animalVaccines")
public class AnimalVaccineController {

    @Autowired
    private IAnimalVaccineService animalVaccineService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalVaccine> findAll() {
        return this.animalVaccineService.findAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalVaccine finByID(@PathVariable("id") int id) {
        return this.animalVaccineService.getByID(id);
    }

    @GetMapping("/getAnimalVaccines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalVaccine> getAnimalVaccines(@PathVariable("id") int id) {
        return animalVaccineService.findAnimalVaccineByAnimalID(id);
    }

    @GetMapping("/getBetween")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AnimalVaccine>> getAnimalVaccinesBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<AnimalVaccine> vaccines = animalVaccineService.findAllByPrtStartBetween(startDate, endDate);
        if (vaccines.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(vaccines);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalVaccine save(@RequestBody AnimalVaccine animalVaccine) {
        return this.animalVaccineService.save(animalVaccine);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public AnimalVaccine update(@RequestBody AnimalVaccine animalVaccine) {
        return animalVaccineService.save(animalVaccine);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        return this.animalVaccineService.delete((int) id);
    }
}
