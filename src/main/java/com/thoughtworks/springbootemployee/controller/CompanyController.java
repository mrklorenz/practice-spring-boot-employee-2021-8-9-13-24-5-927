package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping(path = "/{companyID}")
    public Company findCompanyByID(@PathVariable Integer companyID) {
        return companyService.findCompanyByID(companyID);
    }

    @GetMapping(path = "/{companyID}/employees")
    public List<Employee> getCompanyEmployees(@PathVariable Integer companyID) {
        return companyService.getEmployeeList(companyID);
    }
}
