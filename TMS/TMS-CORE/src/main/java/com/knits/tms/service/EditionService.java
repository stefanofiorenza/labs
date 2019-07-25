package com.knits.tms.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.beans.EditionDto;
import com.knits.tms.dao.EditionDao;
import com.knits.tms.model.Edition;
import com.knits.tms.util.BeanMappingUtils;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EditionService {
	
	@Autowired
	private EditionDao editionDao;

	
	public void saveEdition(EditionDto editionDto) throws ParseException {		
		Edition editionAsModel= BeanMappingUtils.dto2Model(editionDto);
		editionDao.save(editionAsModel);		
	}

}
