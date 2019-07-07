package com.knits.tms.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Work  extends AbstractEntity{
	
	
	@ManyToOne
	@JoinColumn(name = "assessment_id")
	private Assessment assessment;
	
	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private Subscription subscription;
	
	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private Trainer reviewedBy;
	
	@Lob
	@Column(nullable=true)
	private byte[] assessmentSolution;
	
	
	@Column(columnDefinition = "boolean default false")
	private boolean checked;
	
	
	@Temporal(TemporalType.DATE)
	private Date uploadDate;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date checkDate;
	
	
	

}
