package com.knits.tms.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.knits.tms.beans.TrainerDto;
import com.knits.tms.dao.TrainerDao;
import com.knits.tms.service.TrainerService;
import com.knits.tms.model.Trainer;
import com.knits.tms.test.utils.AssertionUtils;
import com.knits.tms.test.utils.MockUtils;

public class TrainerServiceTest {
	
	@InjectMocks	
	private TrainerService trainerService;
	
	@Mock
	private TrainerDao trainerDao;
	
	@Captor
	private ArgumentCaptor<Trainer> trainerArgCaptor;
	
	@Before
	public void init() {	
		trainerService = new TrainerService();
		MockitoAnnotations.initMocks(this); 	
	}
	
	@Test
	public void testSaveTrainer() {
			
		//given ...
		TrainerDto trainerDto = MockUtils.mockTrainerDto();		 
		
		//when
		trainerService.save(trainerDto);
				
	
		//then 
		Mockito.verify(trainerDao,Mockito.times(1)).save(trainerArgCaptor.capture());
		
		Trainer trainer = trainerArgCaptor.getValue();
		
		AssertionUtils.assertDto2ModelMapping(trainerDto,trainer);		
		
	}

}
