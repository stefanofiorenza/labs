package com.knits.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knits.tms.dao.LectureDao;
import com.knits.tms.model.Lecture;

@Service
public class LectureService {
	
	@Autowired
	private LectureDao lectureDao;
	
	public void save(Lecture lecture) {
		lectureDao.save(lecture);
	}

}
