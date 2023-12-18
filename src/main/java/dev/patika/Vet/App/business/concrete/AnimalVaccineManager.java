package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IAnimalVaccineService;
import dev.patika.Vet.App.dao.AnimalVaccineRepository;
import dev.patika.Vet.App.entity.AnimalVaccine;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class AnimalVaccineManager implements IAnimalVaccineService {

    @Autowired
    private AnimalVaccineRepository animalVaccineRepository;

    @Override
    public AnimalVaccine getByID(int id) {
        if (this.animalVaccineRepository.findById(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            return this.animalVaccineRepository.findById(id);
        }
    }



    @Override
    public AnimalVaccine save(AnimalVaccine animalVaccine) {
       Long animalID = animalVaccine.getAnimal().getId();
       Long vaccineID = animalVaccine.getVaccine().getId();
       AnimalVaccine oldVaccine = animalVaccineRepository.findByAnimalIdAndVaccineId(animalID,vaccineID);

       if (oldVaccine != null && oldVaccine.getPrtEnd().isAfter(animalVaccine.getPrtStart())){
           throw  new ResponseStatusException(HttpStatus.CONFLICT);
       }

       return animalVaccineRepository.save(animalVaccine);
    }

    @Override
    public String delete(int id) {
        if (this.animalVaccineRepository.findById(id)==null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            this.animalVaccineRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }
    }

    @Override
    public AnimalVaccine update(AnimalVaccine animalVaccine) {
        AnimalVaccine existingAnimalVaccine = animalVaccineRepository.findById((int) animalVaccine.getId());
        if (existingAnimalVaccine == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            existingAnimalVaccine.setPrtStart(animalVaccine.getPrtStart());
            existingAnimalVaccine.setPrtEnd(animalVaccine.getPrtEnd());
            return this.animalVaccineRepository.save(animalVaccine);
        }

    }

    @Override
    public List<AnimalVaccine> findAll() {
        return this.animalVaccineRepository.findAll();
    }

    @Override
    public List<AnimalVaccine> findAnimalVaccineByAnimalID(int id) {
        AnimalVaccine animalVaccine = animalVaccineRepository.findById(id);
        if (animalVaccine!=null){
            return animalVaccine.getAnimal().getAnimalVaccineList();
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<AnimalVaccine> findAllByPrtStartBetween(LocalDate prt_start, LocalDate prt_end) {
        return animalVaccineRepository.findAllByPrtStartBetween(prt_start,prt_end);
    }


}
