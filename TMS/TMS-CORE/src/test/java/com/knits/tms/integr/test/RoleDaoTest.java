package com.knits.tms.integr.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.RoleDto;
import com.knits.tms.config.AppConfig;
import com.knits.tms.config.GenericTransactionalTest;
import com.knits.tms.dao.RoleDao;
import com.knits.tms.model.Lecture;
import com.knits.tms.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
public class RoleDaoTest extends GenericTransactionalTest {
	
	@Autowired
	private RoleDao roleDao;
	
	@Before
	public void init() {	
		
		super.init();
		 transactionTemplate.execute(new TransactionCallbackWithoutResult() {	
			 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				roleDao.save(mockRole("Admin"));
				roleDao.save(mockRole("Trainer"));
				roleDao.save(mockRole("TeamLead"));
	    		    	
			};	
		 });
	}
	
    @Test
    public void testSaveRole()
    {
        Role roleTest = mockRole("random");
        
        roleDao.save(roleTest);
        
        //Role role = roleDao.findByName("roleTestName");
        
        Assert.assertEquals("random", roleTest.getName());
    }
	
	@Test
	public void testFindByName() {
	
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					Role role =roleDao.findByName("Admin");
					Assert.assertNotNull(role); 	
				};	
		});		
	}
	
	@Test
	public void testUpdate() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
		
		Role role = roleDao.findByName("Admin");
		Assert.assertNotNull(role);
		Assert.assertNotEquals("test", role.getName());
		
		role.setName("test");
		roleDao.update(role);
		Assert.assertEquals("test", role.getName());
				
			}
		});
		
	}
	
	
	
	private Role mockRole (String name) {
		
		Role mockRole = new Role();
		mockRole.setName(name);
		return mockRole;
	}
	
	@After
	public void cleanup() {	
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {	
			 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				for (Role role : roleDao.listAll()){
					roleDao.delete(role);
				}					    	
			};	
		 });
	}
	
}
