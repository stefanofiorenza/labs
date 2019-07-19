package com.knits.tms.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.knits.tms.beans.TagDto;
import com.knits.tms.dao.TagDao;
import com.knits.tms.model.Tag;
import com.knits.tms.test.utils.AssertionUtils;
import com.knits.tms.test.utils.MockUtils;

public class TagServiceTest {
	
	@InjectMocks	
	private TagService tagService;
	
	@Mock
	private TagDao tagDao;
				
	@Captor
	private ArgumentCaptor<Tag> tagArgCaptor;
	
	
	
	@Before
	public void init() {	
		tagService = new TagService();
		MockitoAnnotations.initMocks(this); 	
	}
	
	@Test
	public void testSaveTag() {
			
		//given ...
		TagDto tagDto = MockUtils.mockTagDto();
		tagDto.setName("TestTagName");
			
		//when
		tagService.save(tagDto);
				
	
		//then 
		Mockito.verify(tagDao,Mockito.times(1)).save(tagArgCaptor.capture());
		
		Tag tag =tagArgCaptor.getValue();
		
		AssertionUtils.assertDto2ModelMapping(tagDto,tag);
		Assert.assertEquals("TestTagName",tagDto.getName());					
		
	}

}
