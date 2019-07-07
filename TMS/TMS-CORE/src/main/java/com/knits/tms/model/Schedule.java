package com.knits.tms.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Schedule extends AbstractEntity{

	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Temporal(TemporalType.TIME)
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	private Date endTime;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="lecture_id")
	private Lecture lecture;
		
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainer trainer;
	
	
	private static final long MILLIS_IN_MINUTES=1000*60;
	
	public int lengthInMinutes() {
		if(getEndTime()==null || getStartTime()==null) {			
			return 0;
		}
		return (int)(getEndTime().getTime()-getStartTime().getTime()/MILLIS_IN_MINUTES);
	}
}
