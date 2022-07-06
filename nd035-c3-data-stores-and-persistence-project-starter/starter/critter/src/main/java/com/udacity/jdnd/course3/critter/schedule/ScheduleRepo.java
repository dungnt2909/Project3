package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,Long> {

    List<Schedule> findByEmployees(Employee employee);

    List<Schedule> findByPets(Pet pet);

    List<Schedule> findByPetsIn(List<Pet> listPet);
}
