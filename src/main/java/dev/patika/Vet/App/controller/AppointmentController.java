package dev.patika.Vet.App.controller;

import dev.patika.Vet.App.business.abs.IAppointmentService;
import dev.patika.Vet.App.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> findAll() {
        return this.appointmentService.findAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment finByID(@PathVariable("id") int id) {
        return this.appointmentService.getByID(id);
    }

    @GetMapping("/getByAnimalIdBetween")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> listApoByAnimalIdBetween(
       @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
       @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate endDate,
       @RequestParam("animalId") long id){

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23,59,59);
        return appointmentService.findByAnimalIdBetweenDates(startDateTime,endDateTime,id);
    }

    @GetMapping("/getByDoctorIdBetween")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> listApoByDoctorIdBetween(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate endDate,
            @RequestParam("animalId") long id){
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23,59,59);
        return appointmentService.findByDoctorIdBetweenDates(startDateTime,endDateTime,id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment save(@RequestBody Appointment appointment) {
        return this.appointmentService.save(appointment);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        return this.appointmentService.delete(id);
    }
}
