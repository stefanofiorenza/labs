package com.knits.tms.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knits.tms.beans.TopicDto;
import com.knits.tms.dao.TopicDao;
import com.knits.tms.model.Topic;
import com.knits.tms.util.BeanMappingUtils;

@Transactional(value = TxType.REQUIRED)
@Service
public class TopicService {

	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private BeanMappingUtils beanMappingUtils;
	
	public void save(TopicDto topicDto) {
		Topic topic = beanMappingUtils.dto2Model(topicDto);
		topicDao.save(topic);
	}
}
