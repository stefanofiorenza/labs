package com.knits.tms.util;

import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.model.Employee;

public class BeanMappingUtils {
	
	
	public static Employee dto2Model(EmployeeDto dto ) {		
		
		Employee employee = new Employee();
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		employee.setUsername(dto.getUsername());
		employee.setPassword(dto.getPassword());
		employee.setTeamLead(dto.isTeamLead());
		return employee;
	}

}
