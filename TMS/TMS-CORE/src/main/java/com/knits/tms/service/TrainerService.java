package com.knits.tms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knits.tms.beans.TrainerDto;
import com.knits.tms.dao.TrainerDao;
import com.knits.tms.model.Trainer;
import com.knits.tms.util.BeanMappingUtils;

@Service
@Transactional
public class TrainerService {
	@Autowired
	private TrainerDao trainerDao;
	
	@Autowired
	private BeanMappingUtils beanMappingUtils;
	
	public void save(TrainerDto trainerDto) {
		Trainer trainer = beanMappingUtils.dto2Model(trainerDto);
		trainerDao.save(trainer);
	}
	

//	public List<TrainerDto> findLectureByFilters(LectureSearchDto lectureDto){
//		List<Lecture> lectures = lectureDao.findLectureByFilters(lectureDto);
//		List<LectureDto> lectureDtos = new ArrayList<LectureDto>();
//		
//		for(Lecture lecture : lectures) {
//			lectureDtos.add(beanMappingUtils.model2Dto(lecture));
//		}
//		
//		return lectureDtos;
//	}
}
