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
public abstract class GenericDao<T extends AbstractEntity> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	protected abstract Class<T> getEntityClass();

	public <PK extends Serializable> T findById(PK id) {
		return entityManager.find(getEntityClass(), id);
	}
	
	
	public <PK extends Serializable> List<T> findByIds(Set<PK> ids){
		List<T> resultList= new ArrayList<T>();
		for (PK id : ids){
			resultList.add(findById(id));
		}
		return resultList;
	}
	
	public List<T> listAll(){
		final String query = new StringBuffer("from ").append(
				getEntityClass().getSimpleName()).append(" order by id").toString();		
		return entityManager.createQuery(query,getEntityClass()).getResultList();
	}
			
	public T save(T newInstance) {
		entityManager.persist(newInstance);
		return newInstance;
	}
	

	public void  update(T updatedObject) {
		entityManager.merge(updatedObject);
	}

	
	public <PK extends Serializable> void delete(PK id) {
		T persistentObject = findById(id);
		if(persistentObject==null){
			throw new DaoException("No records found for Id: " + id
					+ " for entity: " + getEntityClass().getSimpleName());
		}
		entityManager.remove(persistentObject);
	}
	
	
	public <PK extends Serializable> void delete(T peristentEntityToDelete) {
		entityManager.remove(peristentEntityToDelete);
	}
	
	public void flush() {
		entityManager.flush();
	}
	
	protected TypedQuery<T> createNamedQuery(String queryName){
		return this.entityManager.createNamedQuery(queryName,getEntityClass());
	}
	
	
	protected TypedQuery<T> createQuery(String jpqlQuery){
		return this.entityManager.createQuery(jpqlQuery,getEntityClass());
	}
		
	protected TypedQuery<T> compileCriteriaQuery(CriteriaQuery<T> criteriaQuery){
		return this.entityManager.createQuery(criteriaQuery);
	}
	
	protected <C> TypedQuery<C> compileCriteriaQuery(Class<C> clazz,CriteriaQuery<C> criteriaQuery){
		return this.entityManager.createQuery(criteriaQuery);
	}
	
	protected CriteriaBuilder getCriteriaBuilder() {		
		return entityManager.getCriteriaBuilder();
	}
	

	
	
}
