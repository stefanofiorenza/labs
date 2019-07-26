package com.knits.tms.integr.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import com.knits.tms.config.GenericTransactionalTest;
import com.knits.tms.dao.RoleDao;
import com.knits.tms.model.Role;

//@Ignore
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
        
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				 roleDao.save(roleTest);
			}
    	});		
       
        
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
		roleDao.save(role);
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
				for (Role role : roleDao.findAll()){
					roleDao.delete(role);
				}					    	
			};	
		 });
	}
	
}
