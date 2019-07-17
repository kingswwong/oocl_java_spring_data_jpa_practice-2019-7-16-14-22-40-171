package com.tw.apistackbase.controller;


import com.tw.apistackbase.entity.EmployeeRecord;
import com.tw.apistackbase.service.EmployeeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/record")
public class EmployeeRecordController {

    @Autowired
    private EmployeeRecordService employeeRecordService;


    @GetMapping
    public List<EmployeeRecord> getEmployeeRecordList() {
        return employeeRecordService.findAll();
    }

    @GetMapping(value = "/{id}")
    public EmployeeRecord findById(@PathVariable("id") int id) {
        return employeeRecordService.findById(id);
    }


    @GetMapping(params = {"page", "pageSize"})
    public Page<EmployeeRecord> findEmployeeRecordPage(@RequestParam(name = "page") int page, @RequestParam(name = "pageSize") int pageSize) {
        return employeeRecordService.findAll(page, pageSize);
    }


    @PostMapping
    public void insert(@RequestBody EmployeeRecord employeeRecord) {
        employeeRecordService.save(employeeRecord);
    }

    @PutMapping
    public void update(@RequestBody EmployeeRecord employeeRecord) {
        employeeRecordService.update(employeeRecord);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        employeeRecordService.delete(id);
    }

}
