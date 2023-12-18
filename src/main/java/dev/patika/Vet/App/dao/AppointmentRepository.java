package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    boolean existsByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime localDateTime);
    List<Appointment> findByAppointmentDateBetweenAndAnimalId(LocalDateTime startDate,LocalDateTime endDate,Long animal_id);
    List<Appointment> findByAppointmentDateBetweenAndDoctorId(LocalDateTime startDate,LocalDateTime endDate,Long animal_id);

    Appointment findById(long id);
}
