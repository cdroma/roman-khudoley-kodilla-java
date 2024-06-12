package com.kodilla.hibernate.manytomany.controller;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/byLastName")
    public List<Employee> getEmployeesByLastName(@RequestParam String lastName) {
        return employeeRepository.findByLastName(lastName);
    }
}
