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
import com.knits.tms.beans.ModuleDto;
import com.knits.tms.dao.CourseDao;
import com.knits.tms.dao.ModuleDao;
import com.knits.tms.model.Course;
import com.knits.tms.model.Module;
import com.knits.tms.test.utils.AssertionUtils;
import com.knits.tms.test.utils.MockUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CourseServiceTest {
	
	@InjectMocks	
	private CourseService courseService;
	
	@Mock
	private CourseDao courseDao;
			
	@Captor
	private ArgumentCaptor<Course> courseArgCaptor;
	
	
	
	@Before
	public void init() {	
		courseService = new CourseService();
		MockitoAnnotations.initMocks(this); 	
	}
	
	
	
	@Test
	public void testSaveCourse() {
			
		//given ...
		CourseDto courseDto = MockUtils.mockCourseDto();
		 
		
		//when
		courseService.saveCourse(courseDto);
				
	
		//then 
		Mockito.verify(courseDao,Mockito.times(1)).save(courseArgCaptor.capture());
		
		Course course = courseArgCaptor.getValue();
		
		AssertionUtils.assertDto2ModelMapping(courseDto,course);
			
		
	}
	

}
