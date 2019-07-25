package com.knits.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.beans.TagDto;
import com.knits.tms.dao.TagDao;
import com.knits.tms.model.Tag;
import com.knits.tms.util.BeanMappingUtils;


@Transactional(propagation = Propagation.REQUIRED)
@Service
public class TagService {
	
	@Autowired
	private TagDao tagDao;
		
	public void save(TagDto tagDto) {
		Tag tag = BeanMappingUtils.dto2Model(tagDto);
		tagDao.save(tag);
	}

}
