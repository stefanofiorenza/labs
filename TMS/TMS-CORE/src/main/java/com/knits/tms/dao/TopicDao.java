package com.knits.tms.dao;

import org.springframework.stereotype.Repository;

import com.knits.tms.model.Topic;

@Repository
public class TopicDao extends GenericDao<Topic> {

	@Override
	protected Class<Topic> getEntityClass() {
		return Topic.class;
	}

	
}
