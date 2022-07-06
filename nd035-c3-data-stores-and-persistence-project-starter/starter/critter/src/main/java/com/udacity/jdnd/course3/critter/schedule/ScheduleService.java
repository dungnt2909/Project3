package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ScheduleService {
    List<Schedule> getAllSchedules();

    Schedule createSchedule(List<Long> petIds, List<Long> employeeIds, Set<EmployeeSkill> activities, LocalDate date);

    List<Schedule> getPetSchedule(long petId);

    List<Schedule> getCustomerSchedule(long customerId);

    List<Schedule> getEmployeeSchedule(long employeeId);
}
