package com.knits.tms.util;

import org.springframework.stereotype.Component;

import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.beans.LectureDto;
import com.knits.tms.model.Employee;
import com.knits.tms.model.Lecture;

@Component
public class BeanMappingUtils {
	
	
	public static Employee dto2Model(EmployeeDto dto ) {		
		throw new UnsupportedOperationException("BeanMappingUtils.dto2Model not implemented");
	}
	
	
	public static Lecture dto2Model(LectureDto dto ) {		
		Lecture lecture = new Lecture();
		lecture.setTitle(dto.getTitle());
		lecture.setContent(dto.getContent());
		return lecture;
	}
	
}
