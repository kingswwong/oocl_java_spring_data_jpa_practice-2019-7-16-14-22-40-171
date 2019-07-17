package com.tw.apistackbase.controller;


import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public List<Employee> getEmployeeList() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Employee findById(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }

    @GetMapping(params = "gender")
    public List<Employee> findAllByGenderEquals(@RequestParam(name = "gender") String gender) {
        return employeeService.findAllByGenderEquals(gender);
    }

    @GetMapping(params = {"page", "pageSize"})
    public Page<Employee> findEmployeePage(@RequestParam(name = "page") int page, @RequestParam(name = "pageSize") int pageSize) {
        return employeeService.findAll(page - 1, pageSize);
    }


    @PostMapping
    public void insert(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PutMapping
    public void update(@RequestBody Employee employee) {
        employeeService.update(employee);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

}
