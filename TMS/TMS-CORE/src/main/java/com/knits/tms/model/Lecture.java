package com.knits.tms.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Lecture extends AbstractEntity {

	private String title;
	private String content;
	
	@ManyToOne
	@JoinColumn(name="edition_id")
	private Edition edition;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy="lecture")	
	@Getter
	private List<Schedule> schedules = new ArrayList<>();
	
}
