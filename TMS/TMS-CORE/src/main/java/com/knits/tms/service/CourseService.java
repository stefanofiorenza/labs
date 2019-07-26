package com.knits.tms.service;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.beans.CourseDto;
import com.knits.tms.beans.CourseSearchDto;
import com.knits.tms.dao.CourseDao;
import com.knits.tms.dao.filters.CourseFilter;
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
		return courseDao.findAll();		
	}
	
	public List<Course> searchCourses(CourseSearchDto filters){
		return courseDao.findAll(new CourseFilter(filters));				
	}

}
