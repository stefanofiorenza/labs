package com.knits.tms.util;

import org.springframework.stereotype.Component;

import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.TopicDto;
import com.knits.tms.model.Employee;
import com.knits.tms.model.Lecture;
import com.knits.tms.model.Topic;

@Component
public class BeanMappingUtils {
	
	
	public static Employee dto2Model(EmployeeDto dto ) {		
		
		Employee employee = new Employee();
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		employee.setUsername(dto.getUsername());
		employee.setPassword(dto.getPassword());
		employee.setTeamLead(dto.isTeamLead());
		return employee;
	}
	
	public static Topic dto2Model(TopicDto dto) {		
		Topic topic = new Topic();
		topic.setName(dto.getName());
		return topic;
	}
	
	
	public static Lecture dto2Model(LectureDto dto) {		
		Lecture lecture = new Lecture();
		lecture.setTitle(dto.getTitle());
		lecture.setContent(dto.getContent());
		return lecture;
	}
	
	public static LectureDto model2Dto(Lecture model) {		
		LectureDto dto = new LectureDto();
		dto.setTitle(model.getTitle());
		dto.setContent(model.getContent());
		return dto;
	}
	
}
