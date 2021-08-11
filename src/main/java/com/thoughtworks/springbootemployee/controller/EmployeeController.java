package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployeeInfo() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{employeeID}")
    public Employee findEmployeeByID(@PathVariable Integer employeeID) {
        return employeeService.findEmployeeById(employeeID);
    }

    @GetMapping(params = "gender")
    public List<Employee> findEmployeesByGender(@RequestParam String gender) {
        return employeeService.findEmployeesByGender(gender);
    }

}