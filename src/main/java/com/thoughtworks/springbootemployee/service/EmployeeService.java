package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Employee> findEmployeesByGender(String employeeGender) {
        return employeeRepository.getEmployees()
                .stream()
                .filter(employee -> employee.getGender().equals(employeeGender))
                .collect(Collectors.toList());
    }

    public List<Employee> findEmployeesByPagination(int pageIndex, int pageSize) {
        int skipValue = (pageIndex - 1) * pageSize;
        return employeeRepository.getEmployees()
                .stream().skip(skipValue).limit(pageSize).collect(Collectors.toList());
    }

    public void addEmployee(Employee employee) {
        employeeRepository.getEmployees().add(new Employee(employeeRepository.getEmployees().size() + 1,
                employee.getName(), employee.getAge(), employee.getGender(), employee.getSalary()));
    }
}
