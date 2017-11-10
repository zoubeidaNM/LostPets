package com.example.lostpets;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long>{
    List<Pet> findAllByNameContains(String str);
    List<Pet> findAllByAgeContains(String str);
    List<Pet> findAllByTypeContains(String str);
    List<Pet> findAllByBreedContains(String str);
    List<Pet> findAllByColorContains(String str);
    List<Pet> findAllByFeaturesContains(String str);
    List<Pet> findAllByPhoneContains(String str);
    List<Pet> findAllByCurrentStatusContains(String str);
}
