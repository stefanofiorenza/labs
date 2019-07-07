package com.knits.tms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Edition  extends AbstractEntity{
	
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
	@Column(columnDefinition = "boolean default false")
	private boolean open;
	
	
	@ManyToOne
	@JoinTable(name = "module_edition",
            joinColumns = @JoinColumn(name = "edition_id"), inverseJoinColumns = @JoinColumn(name = "module_id")
    )
	private Module module;
	
	

	@OneToMany( mappedBy="edition")
	@Getter
	private List<Lecture> lectures = new ArrayList<>();
	
	
	@OneToMany( mappedBy="edition")
	@Getter
	private List<Subscription> subscriptions = new ArrayList<>();
	
}
