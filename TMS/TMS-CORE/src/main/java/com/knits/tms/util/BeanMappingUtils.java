package com.knits.tms.util;

import java.text.ParseException;

import org.springframework.stereotype.Component;

import com.knits.tms.beans.CourseDto;
import com.knits.tms.beans.EditionDto;
import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.ModuleDto;
import com.knits.tms.beans.TopicDto;
import com.knits.tms.beans.TrainerDto;
import com.knits.tms.model.Course;
import com.knits.tms.model.Edition;
import com.knits.tms.model.Employee;
import com.knits.tms.model.Lecture;
import com.knits.tms.model.Module;
import com.knits.tms.model.Topic;
import com.knits.tms.model.Trainer;


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
	
	public static Trainer dto2Model(TrainerDto dto) {		
		Trainer trainer = new Trainer();
		trainer.setFirstName(dto.getFirstName());
		trainer.setLastName(dto.getLastName());
		trainer.setIdCode(dto.getIdCode());
		trainer.setEmail(dto.getEmail());
		return trainer;
	}
	
	public static TrainerDto model2Dto(Trainer model) {		
		TrainerDto dto = new TrainerDto();
		dto.setFirstName(model.getFirstName());
		dto.setLastName(model.getLastName());
		dto.setIdCode(model.getIdCode());
		dto.setEmail(model.getEmail());
		return dto;
	}

	public static Module dto2Model(ModuleDto dto) {		
		Module module = new Module();
		module.setTitle(dto.getTitle());
		module.setProgramPdf(dto.getProgramPdf());;
		return module;
	}
	
	public static ModuleDto model2Dto(Module model) {		
		ModuleDto dto = new ModuleDto();
		dto.setTitle(model.getTitle());
		dto.setProgramPdf(model.getProgramPdf());;
		return dto;
	}
	
	public static Course dto2Model(CourseDto dto) {		
		Course course = new Course();
		course.setTitle(dto.getTitle());
		course.setActive(dto.isActive());
		course.setPublished(dto.isPublished());		
		return course;
	}
	
	public static CourseDto model2Dto(Course model) {		
		CourseDto dto = new CourseDto();
		dto.setTitle(model.getTitle());
		dto.setActive(model.isActive());
		dto.setPublished(model.isPublished());		
		return dto;
	}

	public static Edition dto2Model(EditionDto dto) throws ParseException {		
		Edition edition = new Edition();
		edition.setStartDate(TmsUtils.string2Date(dto.getStartDate()));
		edition.setEndDate(TmsUtils.string2Date(dto.getEndDate()));
		edition.setDeadline(TmsUtils.string2Date(dto.getDeadline()));
		edition.setOpen(dto.isOpen());
		return edition;
	}
	
	public static EditionDto model2Dto(Edition model) {		
		EditionDto dto = new EditionDto();
		dto.setStartDate(TmsUtils.date2String(model.getStartDate()));
		dto.setEndDate(TmsUtils.date2String(model.getEndDate()));
		dto.setDeadline(TmsUtils.date2String(model.getDeadline()));
		dto.setOpen(model.isOpen());
		return dto;
	}
	
	
}
