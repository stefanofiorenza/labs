package com.knits.tms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Assessment  extends AbstractEntity{
	
	@Column(nullable=false)
	private String title;
		
	@Lob
	@Column(nullable=false)
	private byte[] starterZipFile;

	@Column(nullable=false)
	private String starterFileName;
	
	@OneToOne
	@JoinTable(name = "assessment_edition",
     	joinColumns = @JoinColumn(name = "assessment_id"), inverseJoinColumns = @JoinColumn(name = "edition_id")
	)
	private Edition edition;
	
	@OneToMany(mappedBy="assessment")
	@Setter(value=AccessLevel.NONE)
	private List<Work> uploadedWorks = new ArrayList<>();
}
