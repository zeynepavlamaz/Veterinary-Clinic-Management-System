package dev.patika.Vet.App.business.abs;

import dev.patika.Vet.App.entity.Animal;

import java.util.List;

public interface IAnimalService { // Bu kod, bir arayüz (interface) olan IAnimalService'i tanımlar.
    Animal getByID(int id); // Verilen bir hayvanın ID'sine göre bilgilerini getiren bir metodu tanımlar
    Animal save(Animal animal); // Yeni bir hayvan eklemek için kullanılan bir metod.
    String delete(int id); // Belirtilen bir hayvanın ID'sine göre hayvanı silen bir metodu tanımlar
    Animal update(Animal animal); // Var olan bir hayvanın bilgilerini güncellemek için kullanılan bir metodu tanımlar.
    List<Animal> findAll(); // tüm hayvanların listesini getiren bir metodu tanımlar
}
