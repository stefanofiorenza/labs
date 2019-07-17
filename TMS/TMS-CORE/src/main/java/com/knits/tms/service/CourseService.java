package com.knits.tms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.knits.tms.beans.CourseDto;
import com.knits.tms.beans.ModuleDto;
import com.knits.tms.dao.CourseDao;
import com.knits.tms.dao.ModuleDao;
import com.knits.tms.model.Course;
import com.knits.tms.model.Module;
import com.knits.tms.util.BeanMappingUtils;

public class CourseService {
	
	@Autowired
	private CourseDao courseDao;

	
	public void saveCourse(CourseDto courseDto) {		
		Course courseAsModel= BeanMappingUtils.dto2Model(courseDto);
		courseDao.save(courseAsModel);		
	}


}
