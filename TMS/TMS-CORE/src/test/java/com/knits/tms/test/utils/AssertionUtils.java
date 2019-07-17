package com.knits.tms.test.utils;

import org.junit.Assert;

import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.ModuleDto;
import com.knits.tms.beans.TrainerDto;
import com.knits.tms.model.Employee;
import com.knits.tms.model.Lecture;
import com.knits.tms.model.Module;
import com.knits.tms.model.Trainer;

public class AssertionUtils {

	
	public static void assertDto2ModelMapping(EmployeeDto employeeDto, Employee employee) {
		
		Assert.assertTrue(employeeDto.getFirstName().equals(employee.getFirstName()));
		
		Assert.assertTrue(employeeDto.getLastName().equals(employee.getLastName()));
		Assert.assertTrue(employeeDto.getEmail().equals(employee.getEmail()));
		Assert.assertTrue(employeeDto.getUsername().equals(employee.getUsername()));
		Assert.assertTrue(employeeDto.getPassword().equals(employee.getPassword()));
		Assert.assertTrue(employeeDto.isTeamLead()==(employee.isTeamLead()));
	}
	
	public static void assertDto2ModelMapping(LectureDto lectureDto, Lecture lecture) {
		
		Assert.assertTrue(lectureDto.getTitle().equals(lecture.getTitle()));		
		Assert.assertTrue(lectureDto.getContent().equals(lecture.getContent()));
	}

	public static void assertModel2Dto(Lecture lecture, LectureDto lectureDto) {		
		Assert.assertTrue(lecture.getTitle().equals(lectureDto.getTitle()));
		Assert.assertTrue(lecture.getContent().equals(lectureDto.getContent()));
	}

	public static void assertDto2ModelMapping(ModuleDto moduleDto, Module module) {
		Assert.assertTrue(module.getTitle().equals(moduleDto.getTitle()));
		Assert.assertTrue(module.getProgramPdf().equals(moduleDto.getProgramPdf()));
		
	}
	public static void assertDto2ModelMapping(TrainerDto trainerDto, Trainer trainer) {
		Assert.assertTrue(trainer.getFirstName().equals(trainerDto.getFirstName()));
		Assert.assertTrue(trainer.getLastName().equals(trainerDto.getLastName()));
		Assert.assertTrue(trainer.getIdCode().equals(trainerDto.getIdCode()));
		Assert.assertTrue(trainer.getEmail().equals(trainerDto.getEmail()));
	}
	
	
}
