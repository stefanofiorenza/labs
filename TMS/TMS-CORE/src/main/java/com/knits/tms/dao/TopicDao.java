package com.knits.tms.dao;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knits.tms.model.Topic;

@Repository
@Transactional
public interface  TopicDao extends JpaRepository<Topic,Long> {

	 Topic findByName(String name);
	
	/*
	public Topic findByName(String name) {
		
		TypedQuery<Topic> query  =createNamedQuery("Topic.ByName");
		query.setParameter("name", name);
		return query.getSingleResult();
	}*/

	
}
