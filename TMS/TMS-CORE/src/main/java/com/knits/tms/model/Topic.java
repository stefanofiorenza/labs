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
public class Topic extends AbstractEntity{
	
	
	@Getter
	@Setter
	@Column(unique=true)
	private String name;
	
	@ManyToMany(mappedBy="topics" ,cascade = {CascadeType.PERSIST,CascadeType.MERGE })
	@Getter
	private List<Course> courses = new ArrayList<Course>();
	

	
	public Topic (String name) {
		this.name=name;
	}
		
	public Topic () {};
}
