package com.knits.tms.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.knits.tms.model.Topic;

@Repository
public class TopicDao extends GenericDao<Topic> {

	@Override
	protected Class<Topic> getEntityClass() {
		return Topic.class;
	}
	
	public Topic findByName(String name) {
		
		TypedQuery<Topic> query  =createNamedQuery("Topic.ByName");
		query.setParameter("name", name);
		return query.getSingleResult();
	}

	
}
