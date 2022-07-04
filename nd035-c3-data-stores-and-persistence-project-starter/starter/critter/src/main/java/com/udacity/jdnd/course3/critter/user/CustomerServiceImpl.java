package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.PetRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    PetRepo petRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer createdCustomer = new Customer();
        createdCustomer.setId(customerDTO.getId());
        createdCustomer.setName(customerDTO.getName());
        createdCustomer.setPhoneNumber(customerDTO.getPhoneNumber());
        return convertToDTO(customerRepo.save(createdCustomer));
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customerList = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer c : customerList){
            CustomerDTO cDTO = new CustomerDTO();
            cDTO.setId(c.getId());
            cDTO.setName(c.getName());
            cDTO.setPhoneNumber(c.getPhoneNumber());
            customerDTOList.add(cDTO);
        }
        return customerDTOList;
    }

    public CustomerDTO convertToDTO(Customer customer){
        return mapper.map(customer, CustomerDTO.class);
    }

    public Customer convertToEntity(CustomerDTO customerDTO){
        return mapper.map(customerDTO, Customer.class);
    }



}
