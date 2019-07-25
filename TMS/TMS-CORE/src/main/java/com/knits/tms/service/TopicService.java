package com.knits.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.beans.TopicDto;
import com.knits.tms.dao.TopicDao;
import com.knits.tms.model.Topic;
import com.knits.tms.util.BeanMappingUtils;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class TopicService {

	@Autowired
	private TopicDao topicDao;
	
	public void save(TopicDto topicDto) {
		Topic topic = BeanMappingUtils.dto2Model(topicDto);
		topicDao.save(topic);
	}
}
