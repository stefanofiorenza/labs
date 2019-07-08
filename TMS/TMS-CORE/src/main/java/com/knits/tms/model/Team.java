package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Team extends AbstractEntity{

	private String name;
	
	@OneToOne
	@JoinTable(name = "teamlead_team",
		joinColumns = @JoinColumn(name = "team_id"),inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
	private Employee teamLead;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="team")
	@Setter(value=AccessLevel.NONE)
	private List<Employee> teamMembers = new ArrayList<>();
	
}
