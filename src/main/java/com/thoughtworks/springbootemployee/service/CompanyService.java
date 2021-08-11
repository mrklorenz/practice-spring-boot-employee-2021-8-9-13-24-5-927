package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.getCompanies();
    }

    public Company findCompanyByID(Integer companyID) {
        return companyRepository.getCompanies()
                .stream()
                .filter(company -> company.getId().equals(companyID))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> getEmployeeList(Integer companyID) {
        return companyRepository.getCompanies()
                .stream()
                .filter(company -> company.getId().equals(companyID))
                .findFirst()
                .map(Company::getEmployees)
                .get();
    }
}
