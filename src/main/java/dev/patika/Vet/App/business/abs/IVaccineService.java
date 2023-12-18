package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.Vaccine;

import java.util.List;

public interface IVaccineService {
    Vaccine getByID(int id);
    Vaccine save(Vaccine vaccine);
    String delete(int id);
    Vaccine update(Vaccine vaccine);
    List<Vaccine> findAll();
}
