package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {
    private final List<Company> companies = new ArrayList<>();
    private final EmployeeRepository employeeRepository = new EmployeeRepository();

    public CompanyRepository() {
        companies.add(new Company(1, "OOCL", employeeRepository.getEmployees()));
        companies.add(new Company(2, "COSCO", employeeRepository.getEmployees()));
        companies.add(new Company(3, "MAERSK", employeeRepository.getEmployees()));
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
