package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void should_return_all_employees_when_getAllEmployees_given_all_employees() {
        //given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "alice", 20, "female", 1000));
        employees.add(new Employee(2, "bob", 20, "male", 1000));
        employees.add(new Employee(3, "bobsy", 20, "female", 1000));
        employees.add(new Employee(4, "mark", 20, "male", 1000));
        given(employeeRepository.getEmployees()).willReturn(employees);

        //when
        List<Employee> actualEmployees = employeeService.getAllEmployees();

        //then
        assertIterableEquals(employees, actualEmployees);
    }

    @Test
    public void should_return_employee_when_find_employee_by_id_given_employee_id(){
        //given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "alice", 20, "female", 1000));
        employees.add(new Employee(2, "bob", 20, "male", 1000));
        employees.add(new Employee(3, "bobsy", 20, "female", 1000));
        employees.add(new Employee(4, "mark", 20, "male", 1000));
        given(employeeRepository.getEmployees()).willReturn(employees);
        Integer employeeID = 1;


        //when
        Employee actualEmployee = employeeService.findEmployeeById(employeeID);

        //then
        assertEquals(employees.get(0), actualEmployee);
    }

    

}
