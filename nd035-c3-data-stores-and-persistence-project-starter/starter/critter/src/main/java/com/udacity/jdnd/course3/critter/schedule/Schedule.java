package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated
    private long id;

//    @OneToMany( fetch = FetchType.LAZY, mappedBy = "schedule")
//    private Set<Employee> employeeList = new HashSet<>();
//
//    @OneToMany( fetch = FetchType.LAZY, mappedBy = "schedule")
//    private Set<Pet> petList = new HashSet<>();
//
//    private LocalDate date;
//
//    @Enumerated(EnumType.STRING)
//    private EmployeeSkill abilities;

}
