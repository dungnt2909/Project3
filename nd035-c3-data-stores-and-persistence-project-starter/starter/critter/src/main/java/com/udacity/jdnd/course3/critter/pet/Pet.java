package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.schedule.Schedule;
import com.udacity.jdnd.course3.critter.user.Customer;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Generated
    @Column(name = "pet_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private PetType type;

    private String name;

    private LocalDate birthDate;

    private String note;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "schedule_id")
//    private Schedule schedule;
}
