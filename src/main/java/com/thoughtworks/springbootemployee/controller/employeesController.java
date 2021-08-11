package com.thoughtworks.springbootemployee.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class employeesController {
    List<Employee> employees = new ArrayList<>();

    public employeesController() {
        employees.add(new Employee(1,"alice",20,"female",1000));
        employees.add(new Employee(2,"bob",20,"male",1000));

        employees.add(new Employee(3,"bobsy",20,"female",1000));
        employees.add(new Employee(4,"mark",20,"male",1000));
    }

    @GetMapping
    public List<Employee> getAllEmployeeInfo()
    {
        return employees;
    }

}