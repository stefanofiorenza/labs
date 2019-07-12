package com.knits.tms.test.utils;

import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.model.Role;
import com.knits.tms.util.TmsConsts;

public class MockUtils {

	
	public static Role mockAdminRole () {
		Role mockRole =new Role();
		mockRole.setName(TmsConsts.ROLE_ADMIN);
		return mockRole;
	}
	
		
	public static EmployeeDto mockEmployeeDto() {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setFirstName("FirstNameTest");
		employeeDto.setLastName("LastNameTest");
		employeeDto.setEmail("EmailTest");
		employeeDto.setUsername("UsernameTest");
		employeeDto.setPassword("PasswordTest");
		employeeDto.setTeamLead(false);
		return employeeDto;
	}		
}
