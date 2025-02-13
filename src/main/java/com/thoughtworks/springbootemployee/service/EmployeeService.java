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

    public List<Employee> getAllEmployees() {
        return employeeRepository.getEmployees();
    }

    public Employee findEmployeeById(Integer employeeID) {
        return getAllEmployees()
                .stream()
                .filter(employee -> employee.getId().equals(employeeID))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> findEmployeesByGender(String employeeGender) {
        return getAllEmployees()
                .stream()
                .filter(employee -> employee.getGender().equals(employeeGender))
                .collect(Collectors.toList());
    }

    public List<Employee> findEmployeesByPagination(int pageIndex, int pageSize) {
        int skipValue = (pageIndex - 1) * pageSize;
        return getAllEmployees()
                .stream()
                .skip(skipValue)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public void addEmployee(Employee employee) {
        getAllEmployees().add(new Employee(employeeRepository.getEmployees().size() + 1,
                employee.getName(), employee.getAge(), employee.getGender(), employee.getSalary()));
    }

    public Employee updateEmployeeByID(Integer employeeID, Employee employeeDetails) {
        return getAllEmployees()
                .stream()
                .filter(employee -> employee.getId().equals(employeeID))
                .findFirst()
                .map(employee -> updateEmployeeInfo(employee, employeeDetails))
                .get();
    }

    public void deleteEmployeeByID(int employeeID) {
        getAllEmployees()
                .stream()
                .filter(employee -> employee.getId().equals(employeeID))
                .findFirst()
                .ifPresent(employee -> employeeRepository.getEmployees().remove(employee));
    }

    private Employee updateEmployeeInfo(Employee employee, Employee employeeDetails) {

        if (employeeDetails.getName() != null) employee.setName(employeeDetails.getName());
        if (employeeDetails.getAge() != null) employee.setAge(employeeDetails.getAge());
        if (employeeDetails.getGender() != null) employee.setGender(employeeDetails.getGender());
        if (employeeDetails.getSalary() != null) employee.setSalary(employeeDetails.getSalary());

        return employee;
    }


}
