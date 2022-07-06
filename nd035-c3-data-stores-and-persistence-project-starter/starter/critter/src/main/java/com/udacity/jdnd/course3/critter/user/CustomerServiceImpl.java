package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    PetRepo petRepo;
    @Autowired
    CustomerRepo customerRepo;


    public Customer saveCustomer(Customer customer, List<Long> petIds) throws RuntimeException{
        List<Pet> petList = new ArrayList<>();
        if (petIds!=null && !petIds.isEmpty()) {
            for (Long id: petIds) {
                Optional<Pet> optionalPet= petRepo.findById(id);
                if (optionalPet.isPresent()) {
                    petList.add(optionalPet.get());
                } else {
                    throw new RuntimeException("");
                }
            }
        }
        customer.setPets(petList);
        return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getOwnerByPet(long petId) {
        Optional<Pet> optionalPet= petRepo.findById(petId);
        if (!optionalPet.isPresent()) {
            throw new RuntimeException("pet not found");
        }
        return optionalPet.get().getCustomer();
    }

    public Customer getOne(long id){
        return this.customerRepo.getOne(id);
    }

}
