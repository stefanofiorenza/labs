package com.knits.tms.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knits.tms.model.Module;

@Repository
@Transactional
public interface  ModuleDao extends JpaRepository<Module,Long> {
}
