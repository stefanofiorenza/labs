package com.knits.tms.dao;

import org.springframework.stereotype.Repository;

import com.knits.tms.model.Tag;

@Repository
public class TagDao extends GenericDao<Tag>{

	@Override
	protected Class<Tag> getEntityClass() {
		return Tag.class;
	}

	
	
}
