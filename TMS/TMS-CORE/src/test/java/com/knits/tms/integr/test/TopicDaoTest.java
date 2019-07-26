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
import com.knits.tms.dao.TopicDao;
import com.knits.tms.model.Topic;

//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
public class TopicDaoTest extends GenericTransactionalTest {
	
	@Autowired
	private TopicDao topicDao;
	
	@Before
	public void init() {	
		
		super.init();
		 transactionTemplate.execute(new TransactionCallbackWithoutResult() {	
			 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				topicDao.save(mockTopic("OOP"));
				topicDao.save(mockTopic("UTest"));
				topicDao.save(mockTopic("Inheritance"));
	    		    	
			};	
		 });
	}
	
    @Test
    public void testSaveRole()
    {
        Topic topicTest = mockTopic("random");
        
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				 topicDao.save(topicTest);
			}
    	});		
       
        
        //Role role = roleDao.findByName("roleTestName");
        
        Assert.assertEquals("random", topicTest.getName());
    }
	
	@Test
	public void testFindByName() {
	
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					Topic topic =topicDao.findByName("OOP");
					Assert.assertNotNull(topic); 	
				};	
		});		
	}
	
	@Test
	public void testUpdate() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			
		@Override
		protected void doInTransactionWithoutResult(TransactionStatus status) {
				
		
		Topic topic = topicDao.findByName("OOP");
		Assert.assertNotNull(topic);
		Assert.assertNotEquals("test", topic.getName());
		
		topic.setName("test");
		topicDao.save(topic);
		Assert.assertEquals("test", topic.getName());
				
		}
		});
		
	}
	
	private Topic mockTopic (String name) {
		
		Topic mockTopic = new Topic();
		mockTopic.setName(name);
		return mockTopic;
	}
	
	@After
	public void cleanup() {	
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {	
			 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				for (Topic topic : topicDao.findAll()){
					topicDao.delete(topic);
				}					    	
			};	
		 });
	}
	
}
