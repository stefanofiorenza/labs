package com.knits.tms.dao.filters;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.knits.tms.beans.TrainerSearchDto;
import com.knits.tms.model.Trainer;

public class TrainerFilter implements  Specification<Trainer>{

private TrainerSearchDto filter;
	
	public TrainerFilter(TrainerSearchDto filter) {
		this.filter =filter;
	}
	
	
	@Override
	public Predicate toPredicate(Root<Trainer> trainerTable, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		query.distinct(true);
		List<Predicate> predicates = new ArrayList<>();
		
		
		if(!StringUtils.isEmpty(this.filter.getFirstName())) {
			Predicate filterByName = cb.equal(trainerTable.get("firstName"), this.filter.getFirstName());			
			predicates.add(filterByName);
		}
		
		if(!StringUtils.isEmpty(this.filter.getLastName())) {
			Predicate filterByLastName = cb.equal(trainerTable.get("lastName"), this.filter.getLastName());			
			predicates.add(filterByLastName);
		}
		
		if(!StringUtils.isEmpty(this.filter.getEmail())) {
			Predicate filterByEmail = cb.equal(trainerTable.get("email"), this.filter.getEmail());			
			predicates.add(filterByEmail);
		}
		
		if(!StringUtils.isEmpty(this.filter.getIdCode())) {
			Predicate filterByIdCode = cb.equal(trainerTable.get("idCode"), this.filter.getIdCode());			
			predicates.add(filterByIdCode);
		}
		
		 return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

	/*
	private List<Trainer> queryWithCriteriaQuery(TrainerSearchDto trainerDto){
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Trainer> cqueryTrainer =cb.createQuery(Trainer.class);// expected result
		
		Root<Trainer> trainerTable = cqueryTrainer.from(Trainer.class); // table to query
		
		cqueryTrainer.select(trainerTable).distinct(true);
		
		if(!StringUtils.isEmpty(trainerDto.getFirstName())) {
			Predicate filterByName = cb.equal(trainerTable.get("firstName"), trainerDto.getFirstName());			
			cqueryTrainer.where(filterByName);
		}
		
		if(!StringUtils.isEmpty(trainerDto.getLastName())) {
			Predicate filterByLastName = cb.equal(trainerTable.get("lastName"), trainerDto.getLastName());			
			cqueryTrainer.where(filterByLastName);
		}
		
		if(!StringUtils.isEmpty(trainerDto.getEmail())) {
			Predicate filterByEmail = cb.equal(trainerTable.get("email"), trainerDto.getEmail());			
			cqueryTrainer.where(filterByEmail);
		}
		
		if(!StringUtils.isEmpty(trainerDto.getIdCode())) {
			Predicate filterByIdCode = cb.equal(trainerTable.get("idCode"), trainerDto.getIdCode());			
			cqueryTrainer.where(filterByIdCode);
		}
		
		TypedQuery<Trainer> qrtTrainers = compileCriteriaQuery(cqueryTrainer);		 
		return qrtTrainers.getResultList();		
	}*/
}
