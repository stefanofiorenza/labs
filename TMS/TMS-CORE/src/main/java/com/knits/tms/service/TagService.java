package com.knits.tms.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knits.tms.beans.TagDto;
import com.knits.tms.beans.TopicDto;
import com.knits.tms.dao.TagDao;
import com.knits.tms.dao.TopicDao;
import com.knits.tms.model.Tag;
import com.knits.tms.model.Topic;
import com.knits.tms.util.BeanMappingUtils;


@Transactional(value = TxType.REQUIRED)
@Service
public class TagService {
	
	@Autowired
	private TagDao tagDao;
	
	@Autowired
	private BeanMappingUtils beanMappingUtils;
	
	public void save(TagDto tagDto) {
		Tag tag = beanMappingUtils.dto2Model(tagDto);
		tagDao.save(tag);
	}

}
