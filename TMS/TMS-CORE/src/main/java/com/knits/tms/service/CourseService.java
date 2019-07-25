package com.knits.tms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.beans.CourseDto;
import com.knits.tms.dao.CourseDao;
import com.knits.tms.model.Course;
import com.knits.tms.util.BeanMappingUtils;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CourseService {
	
	@Autowired
	private CourseDao courseDao;

	
	public void saveCourse(CourseDto courseDto) {		
		Course courseAsModel= BeanMappingUtils.dto2Model(courseDto);
		courseDao.save(courseAsModel);		
	}
	
	public List<Course> viewAllCourses(){
		List<Course> courses = courseDao.listAll();
		
		return courses;
	}

}
