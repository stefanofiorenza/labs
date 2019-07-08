package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@NamedQueries({
	@NamedQuery(
		name = "Trainer.ByIdCode", 
		query = "from Trainer where idCode = :idCode"			
	)
})
public class Trainer extends AbstractEntity{

	
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String idCode;
	
	private String email;
	
	@OneToMany(fetch=FetchType.LAZY , mappedBy="trainer")
	@Setter(value=AccessLevel.NONE)
	private List<Schedule> lecturesScheduled= new ArrayList<>();
	
	
	
	
}
