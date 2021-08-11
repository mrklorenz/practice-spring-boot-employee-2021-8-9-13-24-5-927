package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.model.Employees;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class employeesController {
    List<Employees> employees = new ArrayList<>();

    public employeesController() {
        employees.add(new Employees(1,"alice",20,"female",1000));
        employees.add(new Employees(2,"bob",20,"male",1000));

        employees.add(new Employees(3,"bobsy",20,"female",1000));
        employees.add(new Employees(4,"mark",20,"male",1000));
    }

    @GetMapping
    public List<Employees> getAllEmployeeInfo()
    {
        return employees;
    }

}