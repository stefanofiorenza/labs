package com.knits.tms.config;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigIntegrationTestEnv.class)
public class GenericTransactionalTest {
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	protected TransactionTemplate transactionTemplate;
	
	public void init() {			
		 transactionTemplate = new TransactionTemplate(transactionManager);		 
	}

}
