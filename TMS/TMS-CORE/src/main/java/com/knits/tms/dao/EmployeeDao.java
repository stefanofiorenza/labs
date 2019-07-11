package com.knits.tms.dao;

import org.springframework.stereotype.Repository;

import com.knits.tms.model.Employee;


@Repository
public class EmployeeDao extends GenericDao<Employee> {

       @Override
       protected Class<Employee> getEntityClass() {
              // TODO Auto-generated method stub
              return null;
       }

}
