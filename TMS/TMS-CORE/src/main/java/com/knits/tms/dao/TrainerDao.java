package com.knits.tms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.knits.tms.beans.LectureSearchDto;
import com.knits.tms.beans.TrainerSearchDto;
import com.knits.tms.model.Lecture;
import com.knits.tms.model.Trainer;

@Repository
@Transactional
public class TrainerDao extends GenericDao<Trainer>{

		
	public Trainer findTrainerByIdCode(String idCode) {		
		 TypedQuery<Trainer> qryTrainerByName = createNamedQuery("Trainer.ByIdCode");
		 qryTrainerByName.setParameter("idCode", idCode);
		 return qryTrainerByName.getSingleResult();
	}
	
	public Trainer findTrainerByIdCodeJqpl(String idCode) {		
		 TypedQuery<Trainer> qryTrainerByName = createQuery("select T from Trainer T where idCode = :idCode");
		 qryTrainerByName.setParameter("idCode", idCode);
		 return qryTrainerByName.getSingleResult();
	}
	
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
	}
	
	public List<Trainer> findTrainerByFilters(TrainerSearchDto trainerDto) {
			return queryWithCriteriaQuery(trainerDto);					
		}

	public List<Trainer> findTrainerByFilters(String firstName, String lastName, String email) {

		CriteriaBuilder crtBuilder = getCriteriaBuilder();
		CriteriaQuery<Trainer> crtQueryTrainer =crtBuilder.createQuery(Trainer.class);// expected result
		
		Root<Trainer> fromTrainer= crtQueryTrainer.from(Trainer.class); // table to query
		crtQueryTrainer.select(fromTrainer);
		
		
		ParameterExpression<String> firstNameAsParam = null;		
		ParameterExpression<String> lastNameAsParam = null;	
		ParameterExpression<String> emailAsParam = null;	
		
		if(!StringUtils.isEmpty(firstName)) {
			firstNameAsParam = crtBuilder.parameter(String.class,"firstName");
			Predicate firstNameFilter = crtBuilder.equal(fromTrainer.get("firstName"), firstNameAsParam);
			crtQueryTrainer = crtQueryTrainer.where(firstNameFilter);
		}		
		
		if(!StringUtils.isEmpty(lastName)) {
			lastNameAsParam = crtBuilder.parameter(String.class,"lastName");
			Predicate lastNameFilter = crtBuilder.equal(fromTrainer.get("lastName"), lastNameAsParam);
			crtQueryTrainer = crtQueryTrainer.where(lastNameFilter);
		}
		
		
		if(!StringUtils.isEmpty(email)) {
			emailAsParam = crtBuilder.parameter(String.class,"email");
			Predicate emailFilter=crtBuilder.equal(fromTrainer.get("email"), emailAsParam);
			crtQueryTrainer= crtQueryTrainer.where(emailFilter);
		}
		
		
		//Add filters
		//List<Predicate> filters = mapIntoFilters(firstName, lastName, email, crtBuilder, fromTrainer);
		//addFiltersToCriteria(crtBuilder, crtQueryTrainer,filters,"findTrainersByFilters");
		
		 //Map<Predicate, ParameterExpression> predicates2Params = mapToFiltersAndParameters(firstName, lastName, email, crtBuilder, fromTrainer);
		
		 //if(predicates2Paramss.size()
		 
		// compile query
		TypedQuery<Trainer> qryTrainerByFilters = compileCriteriaQuery(crtQueryTrainer);
		
		if(firstNameAsParam!=null) {
			qryTrainerByFilters.setParameter(firstNameAsParam, firstName);
		}
		// set parameters
		//setCriteriaQueryParameters(qryTrainerByFilters,firstName, lastName, email, crtBuilder);
		
		return qryTrainerByFilters.getResultList();				
	}
	
	
	private  Map<Predicate, ParameterExpression> mapToFiltersAndParameters(String firstName, String lastName, String email, CriteriaBuilder crtBuilder,
			Root<Trainer> fromTrainer){
		
		Map<Predicate, ParameterExpression> predicates2Params = new HashMap<>();		
		addFilterAndParameter(predicates2Params,"firstName",firstName,String.class,crtBuilder,fromTrainer);
		addFilterAndParameter(predicates2Params,"lastName",firstName,String.class,crtBuilder,fromTrainer);
		addFilterAndParameter(predicates2Params,"email",firstName,String.class,crtBuilder,fromTrainer);		
		
		return predicates2Params;
	}
	
	
	private <T> void addFilterAndParameter(Map<Predicate, ParameterExpression> predicates2Params, String parameterName,Object parameter, Class<T> paramClass,
			CriteriaBuilder crtBuilder,Root<Trainer> fromTrainer) {		
		if(parameter!=null) {
			ParameterExpression firstNameAsParam = crtBuilder.parameter(paramClass,parameterName);
			Predicate firstNameFilter=crtBuilder.equal(fromTrainer.get(parameterName), firstNameAsParam);
			firstNameFilter.alias(parameterName);
			predicates2Params.put(firstNameFilter, firstNameAsParam);
		}
	}
	
	
	
	
	private List<Predicate> mapIntoFilters(String firstName, String lastName, String email, CriteriaBuilder crtBuilder,
			Root<Trainer> fromTrainer) {
		
		List<Predicate> filters = new ArrayList<>();
		
		if(!StringUtils.isEmpty(firstName)) {
			ParameterExpression<String> firstNameAsParam = crtBuilder.parameter(String.class,"firstName");
			Predicate firstNameFilter=crtBuilder.equal(fromTrainer.get("firstName"), firstNameAsParam);
			filters.add(firstNameFilter);
		}
		
		if(!StringUtils.isEmpty(lastName)) {
			ParameterExpression<String> lastNameAsParam = crtBuilder.parameter(String.class,"lastName");
			Predicate firstNameFilter=crtBuilder.equal(fromTrainer.get("lastName"), lastNameAsParam);
			filters.add(firstNameFilter);
		}
		
		if(!StringUtils.isEmpty(email)) {
			ParameterExpression<String> emailAsParam = crtBuilder.parameter(String.class,"email");
			Predicate firstNameFilter=crtBuilder.equal(fromTrainer.get("email"), emailAsParam);
			filters.add(firstNameFilter);
		}
		return filters;
	}
	
	private void setCriteriaQueryParameters(TypedQuery<Trainer> qryTrainerByFilters,String firstName, String lastName, String email,CriteriaBuilder crtBuilder) {
		
		if(!StringUtils.isEmpty(firstName)) {
			ParameterExpression<String> stringAsParam = crtBuilder.parameter(String.class,"firstName");
			qryTrainerByFilters.setParameter(stringAsParam, firstName);
		}
		
		if(!StringUtils.isEmpty(lastName)) {
			ParameterExpression<String> stringAsParam = crtBuilder.parameter(String.class,"lastName");
			qryTrainerByFilters.setParameter(stringAsParam, firstName);
		}
		
		if(!StringUtils.isEmpty(firstName)) {
			ParameterExpression<String> stringAsParam = crtBuilder.parameter(String.class,"email");
			qryTrainerByFilters.setParameter(stringAsParam, firstName);
		}
		
	}

	@Override
	protected Class<Trainer> getEntityClass() {
		return Trainer.class;
	}
	
	

	
	/*
	public List<Trainer> findTrainersByFilters(String firstName, String lastName, String email) {	
		CriteriaBuilder crtBuilder =getCriteriaBuilder();
		CriteriaQuery<Trainer> crtTrainer =crtBuilder.createQuery(Trainer.class);// expected result
		
		Root<Trainer> fromTrainer= crtTrainer.from(Trainer.class); // table to query
		crtTrainer.select(fromTrainer);
		
		
		List<Predicate> filters = setQueryFilters(firstName, lastName, email, crtBuilder, fromTrainer);
				
		for (Predicate predicate : filters) {
			crtTrainer.where(predicate);
		}
		
		//TypedQuery<Trainer> qryTrainerByFilters =createCriteriaQuery(Trainer.class,crtTrainer);
		
		addPredicatesToCriteria(crtBuilder, "findTrainersByFilters", crtTrainer, filters);
		setParametersInQuery(qryTrainerByFilters,firstName, lastName, email, crtBuilder);
		return qryTrainerByFilters.getResultList();		
	}
*/

}
