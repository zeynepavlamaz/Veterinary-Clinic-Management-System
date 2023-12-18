package dev.patika.Vet.App.business.concrete;

import dev.patika.Vet.App.business.abs.IAppointmentService;
import dev.patika.Vet.App.dao.AppointmentRepository;
import dev.patika.Vet.App.dao.DoctorAvailabilityRepository;
import dev.patika.Vet.App.entity.Appointment;
import dev.patika.Vet.App.entity.DoctorAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AppointmentManager implements IAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorAvailabilityRepository doctorAvailabilityRepository;
    @Override
    public Appointment getByID(long id) {
        if (this.appointmentRepository.findById(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            return this.appointmentRepository.findById(id);
        }
    }

    @Override
    public Appointment save(Appointment appointment) {
        LocalDateTime appointmentDate = appointment.getAppointmentDate();
        Long doctorID = appointment.getDoctor().getId();
        DoctorAvailability availableDate = doctorAvailabilityRepository.findByDoctorIdAndAvailableDays(doctorID,appointmentDate.toLocalDate());

        if (availableDate != null && isApointmentExistsOnDate(doctorID,appointmentDate)){
             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            //throw new IllegalStateException("Doctor is not available!");
        }else {
            return this.appointmentRepository.save(appointment);
        }
    }

    @Override
    public String delete(long id) {
        if (this.appointmentRepository.findById(id) == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            this.appointmentRepository.delete(this.getByID(id));
            return "deleted the record with id: " + id;
        }
    }

    @Override
    public Appointment update(Appointment appointment) {
        Appointment existingAppointment = appointmentRepository.findById(appointment.getId());
        if (existingAppointment==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
            existingAppointment.setDoctor(appointment.getDoctor());
            existingAppointment.setAnimal(appointment.getAnimal());
            return this.appointmentRepository.save(appointment);
        }

    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findByAnimalIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long animal_id) {
        return this.appointmentRepository.findByAppointmentDateBetweenAndAnimalId(startDate,endDate,animal_id);
    }

    @Override
    public List<Appointment> findByDoctorIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long doctor_id) {
        return this.appointmentRepository.findByAppointmentDateBetweenAndDoctorId(startDate,endDate,doctor_id);
    }

    private boolean isApointmentExistsOnDate(Long doctorId,LocalDateTime appointmentDate){
        return  appointmentRepository.existsByDoctorIdAndAppointmentDate(doctorId,appointmentDate);
    }


}
