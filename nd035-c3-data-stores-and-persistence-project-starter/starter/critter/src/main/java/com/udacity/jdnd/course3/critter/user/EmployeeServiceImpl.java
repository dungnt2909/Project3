package com.udacity.jdnd.course3.critter.user;

import com.google.common.collect.Sets;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee createdEmployee = new Employee();
        createdEmployee.setId(employeeDTO.getId());
        createdEmployee.setName(employeeDTO.getName());
        createdEmployee.setSkills(employeeDTO.getSkills());
        return convertToDTO(employeeRepo.save(createdEmployee));
    }


    public EmployeeDTO convertToDTO(Employee employee){
        return mapper.map(employee, EmployeeDTO.class);
    }

    public Employee convertToEntity(EmployeeDTO employeeDTO){
        return mapper.map(employeeDTO, Employee.class);
    }
}
