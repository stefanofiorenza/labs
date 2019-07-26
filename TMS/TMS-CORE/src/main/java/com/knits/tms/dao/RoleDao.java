package com.knits.tms.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knits.tms.model.Role;

@Repository
@Transactional
public interface RoleDao extends JpaRepository<Role,Long> {

	 Role findByName(String name);
	
/*
	public Role findByName(String name) {
		
		TypedQuery<Role> query  =createNamedQuery("Role.ByName");
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	
*/
	
}
