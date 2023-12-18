package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability,Long> {
    DoctorAvailability findByDoctorIdAndAvailableDays(Long doctorID, LocalDate appointmentDate);
    DoctorAvailability findById(long id);
}
