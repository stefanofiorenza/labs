package com.knits.tms.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.knits.tms.beans.ModuleDto;
import com.knits.tms.dao.ModuleDao;
import com.knits.tms.model.Module;
import com.knits.tms.test.utils.AssertionUtils;
import com.knits.tms.test.utils.MockUtils;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ModuleServiceTest {
	
	@InjectMocks	
	private ModuleService moduleService;
	
	@Mock
	private ModuleDao moduleDao;
			
	@Captor
	private ArgumentCaptor<Module> moduleArgCaptor;
	
	
	
	@Before
	public void init() {	
		moduleService = new ModuleService();
		MockitoAnnotations.initMocks(this); 	
	}
	
	
	
	@Test
	public void testSaveModule() {
			
		//given ...
		ModuleDto moduleDto = MockUtils.mockModuleDto();
		 
		
		//when
		moduleService.saveModule(moduleDto);
				
	
		//then 
		Mockito.verify(moduleDao,Mockito.times(1)).save(moduleArgCaptor.capture());
		
		Module module = moduleArgCaptor.getValue();
		
		AssertionUtils.assertDto2ModelMapping(moduleDto,module);
			
		
	}
	

}
