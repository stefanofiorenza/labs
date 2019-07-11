package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Employee  extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	private boolean teamLead;
	
	
	@ManyToMany()
	@JoinTable(name = "employee_role",
	    joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	@Getter
	private List<Role> roles = new ArrayList<Role>();
	
	@OneToMany( mappedBy="employee")
	@Getter
	private List<Subscription> subscriptions = new ArrayList<>();
	
	@OneToMany( mappedBy="authorizedBy")
	@Getter
	private List<Subscription> authorizedSubscriptions = new ArrayList<>();
	
	@ManyToOne
	@JoinTable(name = "employee_team",
    	joinColumns = @JoinColumn(name = "employee_id"),
    		inverseJoinColumns = @JoinColumn(name = "team_id")
	)
	private Team team;

}
	
