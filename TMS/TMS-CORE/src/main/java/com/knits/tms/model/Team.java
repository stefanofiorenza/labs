package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper=true)
//@Entity
public class Team extends AbstractEntity{

	private String name;
	
	
	private Employee teamLead;
	
	@Getter
	private List<Employee> teamMembers = new ArrayList<>();
	
}
