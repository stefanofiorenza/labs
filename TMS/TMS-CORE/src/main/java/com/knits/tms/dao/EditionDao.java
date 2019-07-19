package com.knits.tms.dao;

import org.springframework.stereotype.Repository;

import com.knits.tms.model.Edition;


@Repository
public class EditionDao extends GenericDao<Edition> {
	
	  @Override
      protected Class<Edition> getEntityClass() {
             // TODO Auto-generated method stub
             return null;
      }

}
