package com.knits.tms.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@MappedSuperclass
public class AbstractEntity implements Comparable<AbstractEntity>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Getter
	@Setter
	private Long id;

	
	public Boolean isSaved() {
		return id!=null;
	}

	@Override
	public int compareTo(AbstractEntity o) {
		return id.compareTo(o.getId());
	}
	
	@Override
	public boolean equals(Object obj) {	
		if(equalsCheckForNulls(obj)){
			return equalsCheckOnId(obj);
		}else{
			return false;
		}
	
	}
	
	protected boolean equalsCheckForNulls(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	private boolean equalsCheckOnId(Object obj){
		AbstractEntity other = (AbstractEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
}
