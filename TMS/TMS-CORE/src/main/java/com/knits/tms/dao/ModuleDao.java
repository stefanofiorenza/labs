package com.knits.tms.dao;

import org.springframework.stereotype.Repository;

import com.knits.tms.model.Module;

@Repository
public class ModuleDao extends GenericDao<Module> {
	
    @Override
    protected Class<Module> getEntityClass() {
           // TODO Auto-generated method stub
           return null;
    }

}
