package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IDoctorAvailabilityService;
import dev.patika.Vet.App.dao.DoctorAvailabilityRepository;
import dev.patika.Vet.App.entity.DoctorAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DoctorAvailabilityManager implements IDoctorAvailabilityService {

    @Autowired
    private DoctorAvailabilityRepository doctorAvailabilityRepository;

    @Override
    public DoctorAvailability getByID(long id) {

        if (this.doctorAvailabilityRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return this.doctorAvailabilityRepository.findById(id);
        }
    }

    @Override
    public DoctorAvailability save(DoctorAvailability doctorAvailability) {
        return this.doctorAvailabilityRepository.save(doctorAvailability);
    }

    @Override
    public String delete(long id) {
        if (this.doctorAvailabilityRepository.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            this.doctorAvailabilityRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }
    }

    @Override
    public DoctorAvailability update(DoctorAvailability doctorAvailability) {
        DoctorAvailability existingDoctorAv = doctorAvailabilityRepository.findById(doctorAvailability.getId());
        if (existingDoctorAv==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            existingDoctorAv.setAvailableDays(doctorAvailability.getAvailableDays());
            return this.doctorAvailabilityRepository.save(doctorAvailability);
        }

    }

    @Override
    public List<DoctorAvailability> findAll() {
        return this.doctorAvailabilityRepository.findAll();
    }
}
