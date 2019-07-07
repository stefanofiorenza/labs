package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Tag extends AbstractEntity{


	@Getter
	@Setter
	@Column(unique=true)
	private String name;
	
	@ManyToMany(mappedBy="tags" ,cascade = {CascadeType.PERSIST,CascadeType.MERGE })
	@Getter
	private List<Course> courses = new ArrayList<Course>();
	

	public Tag(String name) {
		this.name= name;
	}
	
	public Tag() {};
	
}
