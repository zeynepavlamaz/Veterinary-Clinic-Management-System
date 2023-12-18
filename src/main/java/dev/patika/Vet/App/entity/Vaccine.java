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
@Table(name = "vaccines")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name",nullable = false)
    private String vaccine_name;

    @Column(name = "code",unique = true)
    private String vaccine_code;

    @OneToMany(mappedBy = "vaccine",cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<AnimalVaccine> animalVaccineList;

}
