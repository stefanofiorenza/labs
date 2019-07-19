package com.knits.tms.beans;

import javax.persistence.Column;

import lombok.Data;
@Data
public class TrainerDto {
	private Long id;
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String idCode;
	
	private String email;
	
//	@OneToMany(fetch=FetchType.LAZY , mappedBy="trainer")
//	@Setter(value=AccessLevel.NONE)
//	private List<Schedule> lecturesScheduled= new ArrayList<>();
}
