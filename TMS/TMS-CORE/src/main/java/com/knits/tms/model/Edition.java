package com.knits.tms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Edition  extends AbstractEntity{
	
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
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
	
	

	@OneToMany(fetch=FetchType.LAZY, mappedBy="edition")
	@Setter(value=AccessLevel.NONE)
	private List<Lecture> lectures = new ArrayList<>();
	
	
	@OneToMany(fetch=FetchType.LAZY ,mappedBy="edition")
	@Setter(value=AccessLevel.NONE)
	private List<Subscription> subscriptions = new ArrayList<>();
	
}
