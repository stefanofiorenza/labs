package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Tag extends AbstractEntity{


	@Column(unique=true)
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY ,mappedBy="tags" ,cascade = {CascadeType.PERSIST,CascadeType.MERGE })
	@Setter(value=AccessLevel.NONE)
	private List<Course> courses = new ArrayList<Course>();
	

	public Tag(String name) {
		this.name= name;
	}
	
	public Tag() {};
	
}
