package com.knits.tms.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.knits.tms.beans.CourseDto;
import com.knits.tms.beans.EditionDto;
import com.knits.tms.dao.CourseDao;
import com.knits.tms.dao.EditionDao;
import com.knits.tms.model.Course;
import com.knits.tms.model.Edition;
import com.knits.tms.test.utils.AssertionUtils;
import com.knits.tms.test.utils.MockUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EditionServiceTest {
	
	@InjectMocks	
	private EditionService editionService;
	
	@Mock
	private EditionDao editionDao;
			
	@Captor
	private ArgumentCaptor<Edition> editionArgCaptor;
	
	
	
	@Before
	public void init() {	
		editionService = new EditionService();
		MockitoAnnotations.initMocks(this); 	
	}
	
	
	
	@Test
	public void testSaveEdition() throws Exception{
			
		//given ...
		EditionDto editionDto = MockUtils.mockEditionDto();
		 
		
		//when
		editionService.saveEdition(editionDto);
				
	
		//then 
		Mockito.verify(editionDao,Mockito.times(1)).save(editionArgCaptor.capture());
		
		Edition edition = editionArgCaptor.getValue();
		
		AssertionUtils.assertDto2ModelMapping(editionDto,edition);
			
		
	}

}
