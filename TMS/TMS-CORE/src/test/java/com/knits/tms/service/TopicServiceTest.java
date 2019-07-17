package com.knits.tms.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.knits.tms.beans.TopicDto;
import com.knits.tms.dao.TopicDao;
import com.knits.tms.model.Topic;
import com.knits.tms.test.utils.AssertionUtils;
import com.knits.tms.test.utils.MockUtils;
import com.knits.tms.util.BeanMappingUtils;

public class TopicServiceTest {

	@InjectMocks	
	private TopicService topicService;
	
	@Mock
	private TopicDao topicDao;
				
	@Captor
	private ArgumentCaptor<Topic> topicArgCaptor;
	
	
	
	@Before
	public void init() {	
		topicService = new TopicService();
		MockitoAnnotations.initMocks(this); 	
	}
	
	@Test
	public void testSaveTopic() {
			
		//given ...
		TopicDto topicDto = MockUtils.mockTopicDto();
		topicDto.setName("TestTopicName");
			
		//when
		topicService.save(topicDto);
				
	
		//then 
		Mockito.verify(topicDao,Mockito.times(1)).save(topicArgCaptor.capture());
		
		Topic topic =topicArgCaptor.getValue();
		
		AssertionUtils.assertDto2ModelMapping(topicDto,topic);
		Assert.assertEquals("TestTopicName",topicDto.getName());					
		
	}
	
}
