package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Course  extends AbstractEntity{
	
	private String title;
	
	@Column(columnDefinition = "boolean default false")
	private boolean active;
	
	@Column(columnDefinition = "boolean default false")
	private boolean published;
	
	@ManyToMany(cascade = {CascadeType.PERSIST}) //cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "course_topic",
	    joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "topic_id")
	)
	@Getter
	private List<Topic> topics = new ArrayList<Topic>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST}) //cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinTable(name = "course_tag",
        joinColumns = @JoinColumn(name = "course_id"),inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
	@Getter
	private List<Tag> tags = new ArrayList<Tag>();
	
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="course")	
	@Getter
	private List <Module> modules = new ArrayList<Module>();
	

	


}
