package com.tw.apistackbase.dao;

import com.tw.apistackbase.entity.EmployeeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRecordRepository extends JpaRepository<EmployeeRecord,Integer> {
}
