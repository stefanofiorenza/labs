package com.knits.tms.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.exceptions.DaoException;
import com.knits.tms.model.AbstractEntity;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class GenericDaoBackup {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	

	public <T extends AbstractEntity, PK extends Serializable> T findById(Class<T> newInstance, PK id) {
		return entityManager.find(newInstance, id);
	}
	
	
	public <T extends AbstractEntity, PK extends Serializable> List<T> findByIds(Class<T> clas, Set<PK> ids){
		List<T> resultList= new ArrayList<T>();
		for (PK id : ids){
			resultList.add(findById(clas,id));
		}
		return resultList;
	}
	
	public <T extends AbstractEntity, PK extends Serializable> List<T> listAll(Class<T> entityClass){
		final String query = new StringBuffer("from ").append(
				entityClass.getSimpleName()).append(" order by id").toString();		
		return entityManager.createQuery(query,entityClass).getResultList();
	}
			
	public <T extends AbstractEntity> T save(T newInstance) {
		entityManager.persist(newInstance);
		return newInstance;
	}
	

	public <T> void  update(T updatedObject) {
		entityManager.merge(updatedObject);
	}

	
	public <T extends AbstractEntity, PK extends Serializable> void delete(Class<T> clas, PK id) {
		T persistentObject = entityManager.find(clas, id);
		if(persistentObject==null){
			throw new DaoException("No records found for Id: " + id
					+ " for entity: " + clas.getName());
		}
		entityManager.remove(persistentObject);
	}
	
	
	public <T extends AbstractEntity, PK extends Serializable> void delete(T peristentEntityToDelete) {
		entityManager.remove(peristentEntityToDelete);
	}
	
	public void flush() {
		entityManager.flush();
	}
	
	protected <T extends AbstractEntity> TypedQuery<T> createNamedQuery(Class<T>entityClass, String queryName){
		return this.entityManager.createNamedQuery(queryName,entityClass);
	}
	
	
	protected <T extends AbstractEntity> TypedQuery<T> createQuery(Class<T>entityClass, String jpqlQuery){
		return this.entityManager.createQuery(jpqlQuery,entityClass);
	}
		
	protected <T extends AbstractEntity> TypedQuery<T> compileCriteriaQuery(Class<T>entityClass, CriteriaQuery<T> criteriaQuery){
		return this.entityManager.createQuery(criteriaQuery);
	}
	
	protected CriteriaBuilder getCriteriaBuilder() {		
		return entityManager.getCriteriaBuilder();
	}
	

	protected void addFiltersToCriteria(CriteriaBuilder cb,CriteriaQuery cq, List<Predicate> filtersAsPredicates,String queryName) {
		
		if (filtersAsPredicates.size() == 0) {
			throw new RuntimeException("no Filters for " + queryName + " query");
		} else if (filtersAsPredicates.size() == 1) {
			cq.where(filtersAsPredicates.get(0));
		} else {
			Predicate[] predicatesArr = new Predicate[filtersAsPredicates.size()];
			for (int i = 0; i < filtersAsPredicates.size(); i++) {
				predicatesArr[i] = filtersAsPredicates.get(i);
			}
			cq.where(cb.and(predicatesArr));
			// cq.where(cb.and(filtersAsParams.toArray(new Predicate[0])));
		}
	}
	
	
}
