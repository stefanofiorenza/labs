package com.knits.tms.test.utils;

import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.LectureSearchDto;
import com.knits.tms.beans.TopicDto;
import com.knits.tms.model.Lecture;
import com.knits.tms.model.Role;
import com.knits.tms.model.Topic;
import com.knits.tms.util.TmsConsts;

public class MockUtils {

	
	public static Role mockAdminRole () {
		Role mockRole =new Role();
		mockRole.setName(TmsConsts.ROLE_ADMIN);
		return mockRole;
	}
	
		
	public static EmployeeDto mockEmployeeDto() {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setFirstName("FirstNameTest");
		employeeDto.setLastName("LastNameTest");
		employeeDto.setEmail("EmailTest");
		employeeDto.setUsername("UsernameTest");
		employeeDto.setPassword("PasswordTest");
		employeeDto.setTeamLead(false);
		return employeeDto;
	}
	
	public static TopicDto mockTopicDto() {
		TopicDto topicDto = new TopicDto();
		topicDto.setName("TopicNameTest");
		return topicDto;
	}


	public static LectureDto mockLectureDto() {
		LectureDto lectureDto = new LectureDto();
		lectureDto.setTitle("This Is A Test Title");
		lectureDto.setContent("This Is A Test Content");
		return lectureDto;
	}


	public static LectureSearchDto mockLectureSearchDto() {
		LectureSearchDto lectureSearchDto = new LectureSearchDto();
		lectureSearchDto.setTitle("Testing");
		lectureSearchDto.setContent("Testing");		
		return lectureSearchDto;
	}	
	
	public static Lecture mockLecture() {
		Lecture lecture = new Lecture();
		lecture.setTitle("Testing");
		lecture.setContent("Testing");		
		return lecture;
	}
	
	public static Topic mockTopic() {
		Topic topic = new Topic();
		topic.setName("TopicNameTest");
		return topic;
	}	
}
