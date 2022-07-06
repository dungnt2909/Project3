package com.udacity.jdnd.course3.critter.user;

import java.util.List;

public interface CustomerService {

   Customer saveCustomer(Customer customer, List<Long> petIds) throws RuntimeException;
   List<Customer> getAllCustomers();
   Customer getOwnerByPet(long petId);
}
