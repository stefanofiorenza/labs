package com.knits.tms.integr.test;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.knits.tms.config.GenericTransactionalTest;
import com.knits.tms.dao.TrainerDao;
import com.knits.tms.dao.filters.TrainerFilter;
import com.knits.tms.beans.TrainerSearchDto;
import com.knits.tms.config.AppConfigIntegrationTestEnv;
import com.knits.tms.model.Trainer;


//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
public class TrainerDaoTest extends GenericTransactionalTest{
		
	@Autowired
	private TrainerDao trainerDao;

	
	@Before
	public void init() {	
		
		super.init();
		 transactionTemplate.execute(new TransactionCallbackWithoutResult() {	
			 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				trainerDao.save(mockTrainer("12345"));
	    		trainerDao.save(mockTrainer("123456"));
	    		trainerDao.save(mockTrainer("1234567"));	    	
			};	
		 });
	}
	
	
	
	@Test
	public void testFindByIdCode() {
	
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					Trainer trainer =trainerDao.findByIdCode("123456");
					Assert.assertNotNull(trainer); 	
				};	
		});		
	}
	
	@Test
	public void testFindByIdCodeJpql() {
	
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					Trainer trainer =trainerDao.findByIdCode("123456");
					Assert.assertNotNull(trainer); 	
				};	
		});		
	}
	
	
	@Test
	public void testFindByFilters() {
	
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					TrainerSearchDto searchDto = new TrainerSearchDto();
					searchDto.setFirstName("A Mock FirstName");
					List<Trainer> trainers = trainerDao.findAll(new TrainerFilter(searchDto));
					//List<Trainer> trainers =trainerDao.findTrainerByFilters("A Mock FirstName", null, null);
					Assert.assertEquals(3,trainers.size()); 	
				};	
		});		
	}
	
	private Trainer mockTrainer (String idCode) {
		
		Trainer mockTrainer = new Trainer();
		mockTrainer.setFirstName("A Mock FirstName");
		mockTrainer.setLastName("A Mock Lastname");
		mockTrainer.setEmail("SomeMockEmail");
		mockTrainer.setIdCode(idCode);
		return mockTrainer;
	}
	
	@After
	public void cleanup() {	
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {	
			 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				for (Trainer trainer : trainerDao.findAll()){
					trainerDao.delete(trainer);
				}					    	
			};	
		 });
	}
	
}
