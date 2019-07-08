package com.knits.tms.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Subscription extends AbstractEntity {

	@Column(columnDefinition = "boolean default false")
	private boolean active;
	
	@Column(columnDefinition = "boolean default false")
	private boolean authorized;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Date authorizationUpdateDate;
	
	@ManyToOne
	@JoinColumn(name="employee_id")	
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="edition_id")	
	private Edition edition;
	
	@ManyToOne
	@JoinColumn(name="authorized_by")	
	private Employee authorizedBy;
		

}
