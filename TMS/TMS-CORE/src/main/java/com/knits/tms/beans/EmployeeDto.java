package com.knits.tms.beans;

import lombok.Data;

@Data
public class EmployeeDto {

	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	private boolean teamLead=false;
}
