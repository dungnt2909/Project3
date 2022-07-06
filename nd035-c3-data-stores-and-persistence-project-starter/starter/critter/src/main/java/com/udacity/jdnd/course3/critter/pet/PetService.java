package com.udacity.jdnd.course3.critter.pet;


import java.util.List;

public interface PetService {

    Pet savePet(Pet pet, long ownerId);

    Pet getById(long petId);

    List<Pet> getAllPet();

    List<Pet> getByOwnerId(long ownerId);
}
