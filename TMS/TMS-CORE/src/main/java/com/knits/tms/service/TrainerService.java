package com.knits.tms.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.TrainerDto;
import com.knits.tms.beans.TrainerSearchDto;
import com.knits.tms.dao.TrainerDao;
import com.knits.tms.model.Lecture;
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
	
	public List<TrainerDto> findTrainerByFilters(TrainerSearchDto dto) {
		List<Trainer> trainers = trainerDao.findTrainerByFilters(dto);
		List<TrainerDto> trainerDtos = new ArrayList<TrainerDto>();
		
		for(Trainer trainer : trainers) {
			trainerDtos.add(beanMappingUtils.model2Dto(trainer));
		}
		
		return trainerDtos;
	}

}
