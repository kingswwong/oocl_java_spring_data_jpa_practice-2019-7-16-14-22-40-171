package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getCompanyList() {
        return companyService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Company findById(@PathVariable("id") int id) {
        return companyService.findById(id);
    }

    @GetMapping(value = "/{id}/employees")
    public List<Employee> findCompaniesEmployee(@PathVariable("id") int id) {
        return companyService.findCompaniesEmployee(id);
    }


    @GetMapping(params = {"page", "pageSize"})
    public Page<Company> findAll(@RequestParam(name = "page") int page, @RequestParam(name = "pageSize") int pageSize) {
        return companyService.findAll(page - 1, pageSize);
    }


    @PostMapping
    public List<Company> insert(@RequestBody Company company) {
        companyService.save(company);
        return companyService.findAll();
    }

    @PutMapping
    public void update(@RequestBody Company company) {
        companyService.save(company);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        companyService.delete(id);
    }
}
