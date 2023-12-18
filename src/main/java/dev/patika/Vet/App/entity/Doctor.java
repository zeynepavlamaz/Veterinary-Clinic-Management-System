package dev.patika.Vet.App.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "phone",nullable = false,unique = true)
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "city",nullable = false)
    private String city;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "doctor",cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JsonIgnore
    private List<DoctorAvailability> doctorAvailabilityList;
}
