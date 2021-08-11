package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Employees;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employees> employees= new ArrayList<>();

    public EmployeeRepository() {
        employees.add(new Employees(1,"alice",20,"female",1000));
        employees.add(new Employees(2,"bob",20,"male",1000));

        employees.add(new Employees(3,"bobsy",20,"female",1000));
        employees.add(new Employees(4,"mark",20,"male",1000));
    }

    public List<Employees> getEmployees() {
        return employees;
    }
}
