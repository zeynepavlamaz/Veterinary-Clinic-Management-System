package dev.patika.Vet.App.dao;

import dev.patika.Vet.App.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer> {
      Animal findById(long id);
}
