package com.knits.tms.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.beans.ModuleDto;
import com.knits.tms.dao.ModuleDao;
import com.knits.tms.model.Module;
import com.knits.tms.util.BeanMappingUtils;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ModuleService {
	
	@Autowired
	private ModuleDao moduleDao;

	
	public void saveModule(ModuleDto moduleDto) {		
		Module moduleAsModel= BeanMappingUtils.dto2Model(moduleDto);
		moduleDao.save(moduleAsModel);		
	}

}
