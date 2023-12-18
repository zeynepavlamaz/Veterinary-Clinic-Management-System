package dev.patika.Vet.App.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "appointmentDate",nullable = false)
    private LocalDateTime appointmentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id",referencedColumnName = "id",nullable = false)
    private Animal animal;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id",referencedColumnName = "id",nullable = false)
    private Doctor doctor;

}
