package com.tw.apistackbase.service;

import com.tw.apistackbase.dao.EmployeeRecordRepository;
import com.tw.apistackbase.entity.EmployeeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRecordService {

    @Autowired
    private EmployeeRecordRepository employeeRecordRepository;


    public EmployeeRecord findById(int id) {
        return employeeRecordRepository.getOne(id);
    }

    public List<EmployeeRecord> findAll() {
        return employeeRecordRepository.findAll();
    }

    public Page<EmployeeRecord> findAll(int page, int pageSize) {
        return employeeRecordRepository.findAll(PageRequest.of(page, pageSize));
    }

    public void save(EmployeeRecord company) {
        employeeRecordRepository.save(company);
    }

    public void update(EmployeeRecord company) {
        employeeRecordRepository.save(company);
    }

    public void delete(int id) {
        employeeRecordRepository.delete(findById(id));
    }
}
