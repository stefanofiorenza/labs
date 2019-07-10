package com.knits.tms.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.knits.tms.model.Role;

@Repository
public class RoleDao extends GenericDao<Role> {

	@Override
	protected Class<Role> getEntityClass() {
		return Role.class;
	}
	

	public Role findByName(String name) {
		
		TypedQuery<Role> query  =createNamedQuery("Role.ByName");
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	

	
}
