package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return convertScheduleToScheduleDTO(scheduleService.createSchedule(scheduleDTO.getPetIds(), scheduleDTO.getEmployeeIds(), scheduleDTO.getActivities(), scheduleDTO.getDate()));
    }



    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        for (Schedule s: schedules) {
            scheduleDTOList.add(convertScheduleToScheduleDTO(s));
        }
        return scheduleDTOList;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<Schedule> schedules;
        try {
            schedules = scheduleService.getPetSchedule(petId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet schedule for pet[" + petId + "] not found", e);
        }
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        for (Schedule s: schedules) {
            scheduleDTOList.add(convertScheduleToScheduleDTO(s));
        }
        return scheduleDTOList;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<Schedule> schedules;
        try {
            schedules = scheduleService.getEmployeeSchedule(employeeId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee schedule for employee[" + employeeId + "] not found", e);
        }
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        for (Schedule s: schedules) {
            scheduleDTOList.add(convertScheduleToScheduleDTO(s));
        }
        return scheduleDTOList;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<Schedule> schedules;
        try {
            schedules = scheduleService.getCustomerSchedule(customerId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer schedule for customer[" + customerId + "] not found", e);
        }
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        for (Schedule s: schedules) {
            scheduleDTOList.add(convertScheduleToScheduleDTO(s));
        }
        return scheduleDTOList;    }

    private ScheduleDTO convertScheduleToScheduleDTO(Schedule schedule){
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        BeanUtils.copyProperties(schedule,scheduleDTO);

        scheduleDTO.setEmployeeIds(schedule.getEmployees()
                .stream().map(e -> e.getId())
                .collect(Collectors.toList()));

        scheduleDTO.setPetIds(schedule.getPets()
                .stream().map(p -> p.getId())
                .collect(Collectors.toList()));

        return scheduleDTO;
    }
}

