package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Company> findCompaniesByPagination(int pageIndex, int pageSize) {
        int skipValue = (pageIndex - 1) * pageSize;
        return companyRepository.getCompanies()
                .stream()
                .skip(skipValue)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public void addCompany(Company company) {
        companyRepository.getCompanies().add(new Company(companyRepository.getCompanies().size() + 1,
                company.getName(), company.getEmployees()));
    }

    public Company updateCompanyByID(Integer companyID, Company newCompany) {
        return companyRepository.getCompanies()
                .stream()
                .filter(company -> company.getId().equals(companyID))
                .findFirst()
                .map(company -> updateCompanyInfo(company, newCompany))
                .get();
    }


    public void deleteCompanyByID(int companyID) {
        companyRepository.getCompanies()
                .stream()
                .filter(company -> company.getId().equals(companyID))
                .findFirst()
                .ifPresent(company -> companyRepository.getCompanies().remove(company));
    }

    private Company updateCompanyInfo(Company company, Company newCompany) {
        if (newCompany.getName() != null) company.setName(newCompany.getName());
        if (newCompany.getEmployees() != null) company.setEmployees(newCompany.getEmployees());
        return company;
    }
}
