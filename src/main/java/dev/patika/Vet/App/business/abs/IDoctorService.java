package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.Doctor;

import java.util.List;

public interface IDoctorService {

    Doctor getByID(long id);
    Doctor save(Doctor doctor);
    String delete(long id);
    Doctor update(Doctor doctor);
    List<Doctor> findAll();
}
