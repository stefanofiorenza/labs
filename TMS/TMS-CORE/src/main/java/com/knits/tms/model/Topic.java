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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Entity
@EqualsAndHashCode(callSuper=true)
@Data
@NamedQueries({
	@NamedQuery(
		name = "Topic.ByName", 
		query = "from Topic where name = :name"			
	)
})
public class Topic extends AbstractEntity{
	
	
	@Column(unique=true)
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY ,mappedBy="topics" ,cascade = {CascadeType.PERSIST,CascadeType.MERGE })
	@Setter(value=AccessLevel.NONE)
	private List<Course> courses = new ArrayList<Course>();
	

	
	public Topic (String name) {
		this.name=name;
	}
		
	public Topic () {};
}
