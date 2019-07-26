package com.knits.tms.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.LectureSearchDto;
import com.knits.tms.dao.LectureDao;
import com.knits.tms.dao.filters.LectureFilter;
import com.knits.tms.model.Lecture;
import com.knits.tms.util.BeanMappingUtils;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LectureService {
	
	@Autowired
	private LectureDao lectureDao;
	
	
	public void save(LectureDto lectureDto) {
		Lecture lecture = BeanMappingUtils.dto2Model(lectureDto);
		lectureDao.save(lecture);
	}
	

	public List<LectureDto> findLectureByFilters(LectureSearchDto lectureFilterDto){
		//List<Lecture> lectures = lectureDao.findLectureByFilters(lectureDto);
		
		List<Lecture> lectures = lectureDao.findAll(new LectureFilter(lectureFilterDto));
		List<LectureDto> lectureDtos = new ArrayList<LectureDto>();
		
		for(Lecture lecture : lectures) {
			lectureDtos.add(BeanMappingUtils.model2Dto(lecture));
		}
		
		return lectureDtos;
	}
	
	public void update (LectureDto lectureDto) {
		
		Optional<Lecture> lectureOptional = lectureDao.findById(lectureDto.getId());
		if(lectureOptional.isPresent()) {
			Lecture lecture =lectureOptional.get();
			lecture.setTitle(lectureDto.getTitle());
			lectureOptional.get().setContent(lectureDto.getContent());
			lectureDao.save(lecture);
		}	
	}
	
	public LectureDto findById(Long id) {
		Optional<Lecture> lectureOptional =lectureDao.findById(id);
		if(lectureOptional.isPresent()) {
			Lecture lecture = lectureOptional.get();
			LectureDto dto = BeanMappingUtils.model2Dto(lecture);
			return dto;
		}else {
			return null;
		}
		
	}

}
