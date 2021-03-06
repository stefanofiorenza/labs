package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({
	@NamedQuery(
		name = "Role.ByName", 
		query = "from Role where name = :name"			
	)
})
public class Role extends AbstractEntity{
	
		
	@Getter
	@Setter
	@Column(unique=true)
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY ,mappedBy="roles" ,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@Setter(value=AccessLevel.NONE)
	private List<Employee> employees = new ArrayList<>();
	

	

}
