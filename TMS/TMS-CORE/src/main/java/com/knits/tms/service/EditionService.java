package com.knits.tms.service;

import java.text.ParseException;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knits.tms.beans.EditionDto;
import com.knits.tms.dao.EditionDao;
import com.knits.tms.model.Edition;
import com.knits.tms.util.BeanMappingUtils;


@Service
@Transactional(value = TxType.REQUIRED)
public class EditionService {
	
	@Autowired
	private EditionDao editionDao;

	
	public void saveEdition(EditionDto editionDto) throws ParseException {		
		Edition editionAsModel= BeanMappingUtils.dto2Model(editionDto);
		editionDao.save(editionAsModel);		
	}

}
