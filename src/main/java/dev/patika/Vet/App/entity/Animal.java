package dev.patika.Vet.App.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "breed")
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GENDER gender;

    @Column(name = "colour")
    private String colour;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToMany(mappedBy = "animal",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnimalVaccine> animalVaccineList;

    @OneToMany(mappedBy = "animal",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    public enum GENDER{
        MALE,
        FEMALE
    }


}
