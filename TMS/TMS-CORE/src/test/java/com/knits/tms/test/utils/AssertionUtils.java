package com.knits.tms.test.utils;

import org.junit.Assert;

import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.model.Employee;

public class AssertionUtils {

	
	public static void assertDto2ModelMapping(EmployeeDto employeeDto, Employee employee) {
		
		Assert.assertTrue(employeeDto.getFirstName().equals(employee.getFirstName()));
		
		Assert.assertTrue(employeeDto.getLastName().equals(employee.getLastName()));
		Assert.assertTrue(employeeDto.getEmail().equals(employee.getEmail()));
		Assert.assertTrue(employeeDto.getUsername().equals(employee.getUsername()));
		Assert.assertTrue(employeeDto.getPassword().equals(employee.getPassword()));
		Assert.assertTrue(employeeDto.isTeamLead()==(employee.isTeamLead()));
	}
}