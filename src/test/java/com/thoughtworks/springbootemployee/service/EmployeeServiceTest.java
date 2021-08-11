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
        List<Employee> employees = generateEmployees();
        given(employeeRepository.getEmployees()).willReturn(employees);

        //when
        List<Employee> actualEmployees = employeeService.getAllEmployees();

        //then
        assertIterableEquals(employees, actualEmployees);
    }

    @Test
    public void should_return_employee_when_find_employee_by_id_given_employee_id(){
        //given
        List<Employee> employees = generateEmployees();
        given(employeeRepository.getEmployees()).willReturn(employees);
        Integer employeeID = 1;

        //when
        Employee actualEmployee = employeeService.findEmployeeById(employeeID);

        //then
        assertEquals(employees.get(0), actualEmployee);
    }

    @Test
    public void should_return_employees_when_find_employees_by_gender_given_gender(){
        //given
        List<Employee> employees = generateEmployees();
        given(employeeRepository.getEmployees()).willReturn(employees);
        String gender = "male";

        List<Employee> maleEmployees = new ArrayList<>();
        maleEmployees.add(employees.get(1));
        maleEmployees.add(employees.get(3));

        //when
        List<Employee> actualEmployees = employeeService.findEmployeesByGender(gender);

        //then
        assertIterableEquals(maleEmployees, actualEmployees);
    }

    @Test
    public void should_return_employees_when_find_employees_by_pagination_given_page_index_and_page_size(){
        //given
        List<Employee> employees = generateEmployees();
        given(employeeRepository.getEmployees()).willReturn(employees);
        int pageIndex = 1;
        int pageSize = 3;

        List<Employee> pageEmployees = new ArrayList<>();
        pageEmployees.add(employees.get(0));
        pageEmployees.add(employees.get(1));
        pageEmployees.add(employees.get(2));

        //when
        List<Employee> actualEmployees = employeeService.findEmployeesByPagination(pageIndex, pageSize);

        //then
        assertEquals(pageEmployees.size(), actualEmployees.size());
        assertIterableEquals(pageEmployees, actualEmployees);
    }

    public List<Employee> generateEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "alice", 20, "female", 1000));
        employees.add(new Employee(2, "bob", 20, "male", 1000));
        employees.add(new Employee(3, "bobsy", 20, "female", 1000));
        employees.add(new Employee(4, "mark", 20, "male", 1000));
        return employees;
    }





}
