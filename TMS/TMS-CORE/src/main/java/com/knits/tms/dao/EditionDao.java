package com.knits.tms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.model.Edition;


@Repository
@Transactional
public interface EditionDao extends JpaRepository<Edition,Long> {	

}
