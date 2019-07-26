package com.knits.tms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.model.Employee;


@Repository
@Transactional
public interface EmployeeDao extends JpaRepository<Employee,Long> {
}
