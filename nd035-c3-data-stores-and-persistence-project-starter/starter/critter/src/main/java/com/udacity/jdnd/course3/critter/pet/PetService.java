package com.udacity.jdnd.course3.critter.pet;


import java.util.List;

public interface PetService {

    PetDTO createPet(PetDTO petDTO);

    PetDTO getById(Long petId);

    List<PetDTO> getAllPet();

    List<PetDTO> getByOwnerId(Long ownerId);
}
