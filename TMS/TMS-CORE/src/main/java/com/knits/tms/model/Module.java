package com.knits.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Module  extends AbstractEntity{


	private String title;
		
	@Lob
	@Column(nullable=true)
	private byte[] programPdf;
	
		
	@ManyToOne
	@JoinTable(name = "course_module",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
	private Course course;
	
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy="module")	
	@Getter
	private List<Edition> edition = new ArrayList<>();
	
	
}
	
