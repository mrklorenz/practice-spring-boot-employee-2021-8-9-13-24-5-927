package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees()
    {
        return employeeRepository.getEmployees();
    }

    public Employee findEmployeeById(Integer employeeID) {
        return employeeRepository.getEmployees()
                .stream()
                .filter(employee -> employee.getId().equals(employeeID))
                .findFirst()
                .orElse(null);
    }
}
