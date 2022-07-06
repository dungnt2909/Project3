package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepo;
import com.udacity.jdnd.course3.critter.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    PetRepo petRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    CustomerRepo customerRepo;

    public Schedule createSchedule(List<Long> petIds, List<Long> employeeIds, Set<EmployeeSkill> activities, LocalDate date) {
        List<Pet> pets = petRepo.findAllById(petIds);
        List<Employee> employees = employeeRepo.findAllById(employeeIds);
        Schedule schedule = new Schedule(date, activities);
        schedule.setEmployees(employees);
        schedule.setPets(pets);
        return scheduleRepo.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepo.findAll();
    }

    public List<Schedule> getEmployeeSchedule(long employeeId) {
        Employee employee = employeeRepo.getOne(employeeId);
        List<Schedule> schedules = scheduleRepo.findByEmployees(employee);
        return schedules;
    }

    public List<Schedule> getPetSchedule(long petId) {
        Pet pet = petRepo.getOne(petId);
        List<Schedule> schedules = scheduleRepo.findByPets(pet);
        return schedules;
    }

    public List<Schedule> getCustomerSchedule(long customerId) {
        Customer customer = customerRepo.getOne(customerId);
        List<Schedule> schedules = scheduleRepo.findByPetsIn(customer.getPets());
        return schedules;
    }
}
