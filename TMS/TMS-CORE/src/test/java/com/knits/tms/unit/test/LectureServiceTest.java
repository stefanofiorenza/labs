package com.knits.tms.unit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.dao.LectureDao;
import com.knits.tms.model.Lecture;
import com.knits.tms.service.LectureService;
import com.knits.tms.util.BeanMappingUtils;

@RunWith(MockitoJUnitRunner.class)
public class LectureServiceTest {
	
	@Mock
	LectureDao aMockedLectureDao;
	
	@Mock
	BeanMappingUtils beanMappingUtils;
	
	@InjectMocks
	private LectureService lectureService;
	
	@Before
	public void setup() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void sanity() throws Exception {
		assertNotNull(aMockedLectureDao);
	}
	
	@Test
	public void testSave() {
		//given...
		Lecture lecture = new Lecture();

		lecture.setTitle("mockTitle");
		lecture.setContent("mockContent");
		

	    when(aMockedLectureDao.save(any(Lecture.class))).thenAnswer(new Answer<Lecture>() {
	    	    @Override
	            public Lecture answer(InvocationOnMock invocation) throws Throwable {

	            	Lecture lecture = (Lecture) invocation.getArguments()[0];

	            	lecture.setId(1L);;

	                return lecture;
	            }

	        });

	    assertNull(lecture.getId());
	    
	    //when...

	    lectureService.save(lecture);
	    
	    //then..

	    assertNotNull(lecture.getId());

	    assertTrue(lecture.getId()>0);
	}
	


}