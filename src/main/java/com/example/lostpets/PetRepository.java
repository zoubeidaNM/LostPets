package com.example.lostpets;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long>{
    List<Pet> findAllByNameContains(String str);
}
