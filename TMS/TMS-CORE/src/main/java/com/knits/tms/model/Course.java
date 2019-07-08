package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Course  extends AbstractEntity{
	
	@Column(nullable=false)
	private String title;
	
	@Column(columnDefinition = "boolean default false")
	private boolean active;
	
	@Column(columnDefinition = "boolean default false")
	private boolean published;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "course_topic",
	    joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "topic_id")
	)
	@Setter(value=AccessLevel.NONE)
	private List<Topic> topics = new ArrayList<Topic>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinTable(name = "course_tag",
        joinColumns = @JoinColumn(name = "course_id"),inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
	@Setter(value=AccessLevel.NONE)
	private List<Tag> tags = new ArrayList<Tag>();
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy="course")	
	@Setter(value=AccessLevel.NONE)
	private List <Module> modules = new ArrayList<Module>();
	

	public void addTag(Tag tag) {
		tags.add(tag);
		tag.getCourses().add(this);
	}
	
	public void removeTag(Tag tag) {
		tags.remove(tag);
		tag.getCourses().remove(this);
	}


	public void addTopic(Topic topic) {
		topics.add(topic);
		topic.getCourses().add(this);
	}
	
	public void removeTopic(Topic topic) {
		topics.remove(topic);
		topic.getCourses().remove(this);
	}
}
