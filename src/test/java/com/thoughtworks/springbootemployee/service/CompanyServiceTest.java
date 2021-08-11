package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
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
public class CompanyServiceTest {
    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void should_return_all_companies_when_getAllCompanies_given_all_companies() {
        //given
        List<Company> companies = generateCompanies();
        given(companyRepository.getCompanies()).willReturn(companies);

        //when
        List<Company> actualCompanies = companyService.getAllCompanies();

        //then
        assertIterableEquals(companies, actualCompanies);
    }

    @Test
    public void should_return_company_when_find_company_by_id_given_company_id() {
        //given
        List<Company> companies = generateCompanies();
        given(companyRepository.getCompanies()).willReturn(companies);
        Integer companyID = 1;

        //when
        Company actualCompany = companyService.findCompanyByID(companyID);

        //then
        assertEquals(companies.get(0), actualCompany);
    }

    private List<Company> generateCompanies() {
        List<Company> companies = new ArrayList<>();
        companies.add(new Company(1, "OOCL", employeeRepository.getEmployees()));
        companies.add(new Company(2, "COSCO", employeeRepository.getEmployees()));
        companies.add(new Company(3, "MAERSK", employeeRepository.getEmployees()));
        return companies;
    }
}
