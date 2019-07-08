package com.knits.tms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class LectureReservation extends AbstractEntity {

	
	@Column(columnDefinition = "boolean default false")
	private boolean notificationSent;	
		
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="schedule_id")
	private Schedule schedule;
}
