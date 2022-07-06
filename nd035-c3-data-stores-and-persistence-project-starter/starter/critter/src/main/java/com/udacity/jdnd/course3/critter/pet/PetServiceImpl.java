package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
        @Autowired
        PetRepo petRepo;

        @Autowired
        CustomerRepo customerRepo;

        public Pet savePet(Pet pet, long ownerId) {
            Customer customer = customerRepo.getOne(ownerId);
            List<Pet> petList = customer.getPets();
            pet.setCustomer(customer);
            pet = petRepo.save(pet);
            petList.add(pet);
            customer.setPets(petList);
            customerRepo.save(customer);
            return pet;
        }

        public Pet getById(long petId) {
            return petRepo.getOne(petId);
        }

        public List<Pet> getByOwnerId(long ownerId) {
            return petRepo.findByCustomerId(ownerId);
        }

        public List<Pet> getAllPet() {
            return petRepo.findAll();
        }
    }