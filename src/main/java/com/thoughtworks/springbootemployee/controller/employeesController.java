package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.service.EmployeeService;
import com.thoughtworks.springbootemployee.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public List<Employees> getAllEmployeeInfo()
    {
        return employeeService.getAllEmployees();
    }

}