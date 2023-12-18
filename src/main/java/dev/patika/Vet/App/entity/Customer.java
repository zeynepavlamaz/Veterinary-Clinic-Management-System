package dev.patika.Vet.App.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "phone",nullable = false,unique = true)
    private String phone;

    @Column(name = "mail",unique = true)
    private String mail;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "city",nullable = false)
    private String city;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Animal> animalList;
}
