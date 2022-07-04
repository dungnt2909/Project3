package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepo petRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public PetDTO createPet(PetDTO petDTO) {
        Pet createdPet = new Pet();
        Customer customer = customerRepo.findById(petDTO.getOwnerId()).orElse(null);
        createdPet.setName(petDTO.getName());
        createdPet.setType(petDTO.getType());
        createdPet.setBirthDate(petDTO.getBirthDate());
        createdPet.setNote(petDTO.getNotes());
        createdPet.setCustomer(customer);
        return convertToDTO(petRepo.save(createdPet));
    }

    @Override
    public PetDTO getById(Long petId) {
       Pet pet = petRepo.findById(petId).orElse(null);
       return convertToDTO(pet);
    }

    @Override
    public List<PetDTO> getAllPet() {
        List<Pet> petList = petRepo.findAll();
        List<PetDTO> petDTOList = new ArrayList<>();
        for(Pet p : petList){
            PetDTO pDTO = new PetDTO();
            pDTO.setId(p.getId());
            pDTO.setName(p.getName());
            pDTO.setType(p.getType());
            pDTO.setBirthDate((p.getBirthDate()));
            pDTO.setNotes(p.getNote());
            pDTO.setOwnerId(p.getCustomer().getId());

            petDTOList.add(pDTO);
        }
        return petDTOList;
    }

    @Override
    public List<PetDTO> getByOwnerId(Long ownerId) {
        List<Pet> petList = petRepo.getByOwnerId(ownerId);
        List<PetDTO> petDTOList = new ArrayList<>();
        for(Pet p : petList){
            PetDTO pDTO = new PetDTO();
            pDTO.setId(p.getId());
            pDTO.setName(p.getName());
            pDTO.setType(p.getType());
            pDTO.setBirthDate((p.getBirthDate()));
            pDTO.setNotes(p.getNote());
            pDTO.setOwnerId(p.getCustomer().getId());

            petDTOList.add(pDTO);
        }
        return petDTOList;
    }

    public PetDTO convertToDTO(Pet pet){
        return mapper.map(pet, PetDTO.class);
    }

    public Pet convertToEntity(PetDTO petDTO){
        return mapper.map(petDTO, Pet.class);
    }
}
