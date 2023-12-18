package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByName(String name);
    Customer findById(long id);
}
