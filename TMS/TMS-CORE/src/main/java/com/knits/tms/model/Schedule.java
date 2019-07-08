package com.knits.tms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="schedule")	
	@Setter(value=AccessLevel.NONE)
	private List<LectureReservation> reservations = new ArrayList<>();
	
	
	private static final long MILLIS_IN_MINUTES=1000*60;
	
	public int lengthInMinutes() {
		if(getEndTime()==null || getStartTime()==null) {			
			return 0;
		}
		return (int)(getEndTime().getTime()-getStartTime().getTime()/MILLIS_IN_MINUTES);
	}
}
