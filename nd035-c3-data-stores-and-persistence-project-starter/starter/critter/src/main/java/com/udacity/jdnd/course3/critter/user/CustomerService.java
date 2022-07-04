package com.udacity.jdnd.course3.critter.user;

import java.util.List;

public interface CustomerService {

   CustomerDTO createCustomer(CustomerDTO customerDTO);

   List<CustomerDTO> findAll();
}
