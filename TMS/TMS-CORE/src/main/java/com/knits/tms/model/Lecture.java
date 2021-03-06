package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;


@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Lecture extends AbstractEntity {

	@Column(nullable=false)
	private String title;	
	
	private String content;
	
	@ManyToOne
	@JoinColumn(name="edition_id")
	private Edition edition;

	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST, mappedBy="lecture")	
	@Setter(value=AccessLevel.NONE)
	private List<Schedule> schedules = new ArrayList<>();
	
}
