package dev.patika.Vet.App.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor_available_days")
public class DoctorAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "availableDays",nullable = false)
    private LocalDate availableDays;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private  Doctor doctor;
}
