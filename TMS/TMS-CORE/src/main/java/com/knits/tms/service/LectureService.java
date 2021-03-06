package com.knits.tms.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.LectureSearchDto;
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
	

	public List<LectureDto> findLectureByFilters(LectureSearchDto lectureDto){
		List<Lecture> lectures = lectureDao.findLectureByFilters(lectureDto);
		List<LectureDto> lectureDtos = new ArrayList<LectureDto>();
		
		for(Lecture lecture : lectures) {
			lectureDtos.add(beanMappingUtils.model2Dto(lecture));
		}
		
		return lectureDtos;
	}
	
	public void update (LectureDto lectureDto) {
		if((lectureDao.findById(lectureDto.getId()) != null)){
		Lecture lecture = lectureDao.findById(lectureDto.getId());
		lecture.setTitle(lectureDto.getTitle());
		lecture.setContent(lectureDto.getContent());
		lectureDao.update(lecture);
		}
		else {
			
		}
	}
	
	public LectureDto findById(Long id) {
		Lecture lecture = lectureDao.findById(id);
		LectureDto dto = beanMappingUtils.model2Dto(lecture);
		return dto;
	}

}
