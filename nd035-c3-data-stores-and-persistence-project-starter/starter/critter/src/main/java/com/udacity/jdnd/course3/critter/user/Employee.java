package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.schedule.Schedule;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;


import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> skills;

    @ElementCollection
    @Column(name = "days_available")
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> daysAvailable;

//    @ManyToOne
//    @JoinColumn(name = "schedule_id")
//    private Schedule schedule;

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }
}
