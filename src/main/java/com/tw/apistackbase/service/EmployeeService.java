package com.tw.apistackbase.service;

import com.tw.apistackbase.dao.EmployeeRepository;
import com.tw.apistackbase.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee findById(int id) {
        return employeeRepository.getOne(id);
    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Page<Employee> findAll(int page, int pageSize) {
        return employeeRepository.findAll(PageRequest.of(page, pageSize));
    }

    public List<Employee> findAllByGenderEquals(String gender) {
        return employeeRepository.findAllByGenderEquals(gender);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void update(Employee employee) {
       employeeRepository.save(employee);
    }

    public void delete(int id) {
         employeeRepository.delete(findById(id));
    }

}
