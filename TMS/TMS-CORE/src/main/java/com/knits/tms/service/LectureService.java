package com.knits.tms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.dao.LectureDao;
import com.knits.tms.model.Lecture;
import com.knits.tms.util.BeanMappingUtils;

@Service
@Transactional
public class LectureService {
	
	@Autowired
	private LectureDao lectureDao;
	
	@Autowired
	private BeanMappingUtils beanMappingUtils;
	
	public void save(LectureDto lectureDto) {
		Lecture lecture = beanMappingUtils.dto2Model(lectureDto);
		lectureDao.save(lecture);
	}
	
	public void save(Lecture lecture) {
		lectureDao.save(lecture);
	}

}
