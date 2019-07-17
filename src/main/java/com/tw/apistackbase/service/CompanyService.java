package com.tw.apistackbase.service;

import com.tw.apistackbase.dao.CompanyRepository;
import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    public Company findById(int id) {
        return companyRepository.getOne(id);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Page<Company> findAll(int page, int pageSize) {
        return companyRepository.findAll(PageRequest.of(page, pageSize));
    }

    public void save(Company company) {
        companyRepository.save(company);
    }

    public void update(Company company) {
        companyRepository.save(company);
    }

    public void delete(int id) {
        companyRepository.delete(findById(id));
    }

    public List<Employee> findCompaniesEmployee(int id){
        return companyRepository.getOne(id).getEmployeeList();
    }
}
