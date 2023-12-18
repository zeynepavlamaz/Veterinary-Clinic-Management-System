package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.AnimalVaccine;

import java.time.LocalDate;
import java.util.List;

public interface IAnimalVaccineService {
    AnimalVaccine getByID(int id);
    AnimalVaccine save(AnimalVaccine animalVaccine);
    String delete(int id);
    AnimalVaccine update(AnimalVaccine animalVaccine);
    List<AnimalVaccine> findAll();
    List<AnimalVaccine> findAnimalVaccineByAnimalID(int id);
    List<AnimalVaccine> findAllByPrtStartBetween(LocalDate prt_start, LocalDate prt_end);

}
