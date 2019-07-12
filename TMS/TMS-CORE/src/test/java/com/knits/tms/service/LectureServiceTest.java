package com.knits.tms.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.dao.LectureDao;
import com.knits.tms.model.Lecture;
import com.knits.tms.test.utils.AssertionUtils;
import com.knits.tms.test.utils.MockUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LectureServiceTest {

	@InjectMocks	
	private LectureService lectureService;
	
	@Mock
	private LectureDao lectureDao;
	
	@Captor
	private ArgumentCaptor<Lecture> lectureArgCaptor;
	
	@Before
	public void init() {	
		lectureService = new LectureService();
		MockitoAnnotations.initMocks(this); 	
	}
	
	@Test
	public void testSaveLecture() {
			
		//given ...
		LectureDto lectureDto = MockUtils.mockLectureDto();		 
		
		//when
		lectureService.save(lectureDto);
				
	
		//then 
		Mockito.verify(lectureDao,Mockito.times(1)).save(lectureArgCaptor.capture());
		
		Lecture lecture = lectureArgCaptor.getValue();
		
		AssertionUtils.assertDto2ModelMapping(lectureDto,lecture);		
		
	}
}
