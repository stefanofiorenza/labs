package com.knits.tms.util;

import org.springframework.stereotype.Component;

import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.TrainerDto;
import com.knits.tms.model.Employee;
import com.knits.tms.model.Lecture;
import com.knits.tms.model.Trainer;
import com.knits.tms.beans.ModuleDto;
import com.knits.tms.model.Employee;
import com.knits.tms.model.Lecture;
import com.knits.tms.model.Module;


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
	
}
