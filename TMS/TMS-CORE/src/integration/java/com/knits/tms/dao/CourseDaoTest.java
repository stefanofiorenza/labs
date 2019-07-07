package com.knits.tms.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import com.knits.tms.beans.CourseSearchDto;
import com.knits.tms.config.GenericTransactionalTest;
import com.knits.tms.model.Course;
import com.knits.tms.model.Tag;
import com.knits.tms.model.Topic;


@RunWith(SpringJUnit4ClassRunner.class)
public class CourseDaoTest extends GenericTransactionalTest{

	@Autowired
	private CourseDao courseDao;

	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private TagDao tagDao;
	
	
	@Before
	public void init() {	
		
		 super.init();
		 
		 cleanup();
		 saveTestData();
		
	}
	
	
	@Test
	public void testSearch() {
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				CourseSearchDto courseFilterByTitle = new CourseSearchDto();
				courseFilterByTitle.setTitle("title1");
				List<Course> courses =courseDao.findCourseByFilters(courseFilterByTitle);				
				Assert.assertEquals(1, courses.size());
				
				
			}
		});
		
	}
	
	
	Course mockCourse(String title,int noTags, int noTopics) {
		Course course = new Course();
		
		course.setTitle(title);
		course.setActive(false);
		course.setPublished(true);
		
		for (int i=0; i<noTags; i++) {
			course.getTags().add(new Tag(title+".AMockTag"+i));
		}
		
		for (int i=0; i<noTopics; i++) {
			course.getTopics().add(new Topic(title+".AMockTopic"+i));
		}
		
		return course;		
	}
	
	
	private void saveTestData() {
		 transactionTemplate.execute(new TransactionCallbackWithoutResult() {	
			 
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
										
					courseDao.save(mockCourse("title1",2,3));
					courseDao.save(mockCourse("title2",3,3));
					courseDao.save(mockCourse("title3",2,0));	    	
				};	
			 });
	}
	
	private void cleanup() {
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

				for (Tag tag: tagDao.listAll()) {
					tagDao.delete(tag);
				}
				
				for (Topic topic: topicDao.listAll()) {
					topicDao.delete(topic);
				}
				
				for (Course course: courseDao.listAll()) {
					courseDao.delete(course);
				}
			}
		});
		
		
		
		
	}
	
}
