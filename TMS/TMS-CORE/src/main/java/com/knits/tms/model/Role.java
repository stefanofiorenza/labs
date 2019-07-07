package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Role extends AbstractEntity{
	
		
	@Getter
	@Setter
	private String name;
	
	@ManyToMany(mappedBy="roles" ,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@Getter
	private List<Employee> employees = new ArrayList<>();
	

	

}
