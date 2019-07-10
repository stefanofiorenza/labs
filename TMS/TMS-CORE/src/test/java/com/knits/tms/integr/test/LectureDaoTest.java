package com.knits.tms.integr.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import com.knits.tms.beans.CourseSearchDto;
import com.knits.tms.beans.LectureDto;
import com.knits.tms.config.GenericTransactionalTest;
import com.knits.tms.dao.CourseDao;
import com.knits.tms.dao.GenericDao;
import com.knits.tms.dao.LectureDao;
import com.knits.tms.dao.TagDao;
import com.knits.tms.dao.TopicDao;
import com.knits.tms.model.Course;
import com.knits.tms.model.Lecture;
import com.knits.tms.model.Tag;
import com.knits.tms.model.Topic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class LectureDaoTest extends GenericTransactionalTest {
	
	@Autowired
	private LectureDao lectureDao;
	@Autowired
	private GenericDao<Lecture> genericDao;

	
	@Before
	public void init() {	
		
		 super.init();
		 
		 cleanup();
		 saveTestData();
		
	}
	
	@Test
	public void testSave() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
		LectureDto lectureFilterByTitle = new LectureDto();
		lectureFilterByTitle.setTitle("titleSaveTest");
		
		List<Lecture> lectures = lectureDao.findLectureByFilters(lectureFilterByTitle);
		Assert.assertEquals(0, lectures.size());
		
		Lecture lecture = new Lecture();

		lecture.setTitle("titleSaveTest");
		lecture.setContent("contentSaveTest");

		lectureDao.save(lecture);
	
		lectures =lectureDao.findLectureByFilters(lectureFilterByTitle);
		
		Assert.assertEquals(1, lectures.size());
		
		lecture =lectures.get(0);
		
		Assert.assertEquals("titleSaveTest", lecture.getTitle());
		Assert.assertEquals("contentSaveTest",lecture.getContent());
			}
		});
		
	}
	
	
	@Test
	public void testUpdate() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
		LectureDto lectureFilterByTitle = new LectureDto();
		lectureFilterByTitle.setTitle("title1");
		
		List<Lecture> lectures = lectureDao.findLectureByFilters(lectureFilterByTitle);
		Assert.assertEquals(1, lectures.size());
		
		Lecture lecture =lectures.get(0);	
		Assert.assertNotEquals("testTitle", lecture.getTitle());
		Assert.assertNotEquals("testContent",lecture.getContent());

		lecture.setTitle("testTitle");
		lecture.setContent("testContent");

		lectureDao.update(lecture);
		
		lectureFilterByTitle.setTitle("testTitle");
		lectures =lectureDao.findLectureByFilters(lectureFilterByTitle);
		
		lecture =lectures.get(0);
		
		Assert.assertEquals("testTitle", lecture.getTitle());
		Assert.assertEquals("testContent",lecture.getContent());
			}
		});
		
	}
	
	@Test
	public void testDelete() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				LectureDto lectureFilterByTitle = new LectureDto();
				lectureFilterByTitle.setTitle("title1");
				
				List<Lecture> lectures = lectureDao.findLectureByFilters(lectureFilterByTitle);
				Assert.assertEquals(1, lectures.size());
				
				Lecture lecture =lectures.get(0);	

				lectureDao.delete(lecture);
				
				lectures =lectureDao.findLectureByFilters(lectureFilterByTitle);
				Assert.assertEquals(0, lectures.size());
				
				
			}
		});
		
	}
	
	
	Lecture mockLecture(String title,String content) {
		Lecture lecture = new Lecture();
		
		lecture.setTitle(title);
		lecture.setContent(content);
		
		
//		for (int i=0; i<noTags; i++) {
//			course.getTags().add(new Tag(title+".AMockTag"+i));
//		}
//		
//		for (int i=0; i<noTopics; i++) {
//			course.getTopics().add(new Topic(title+".AMockTopic"+i));
//		}
		
		return lecture;		
	}

	private void saveTestData() {
		 transactionTemplate.execute(new TransactionCallbackWithoutResult() {	
			 
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
										
					lectureDao.save(mockLecture("title1","content1"));
					lectureDao.save(mockLecture("title2","content2"));
					lectureDao.save(mockLecture("title3","content3"));
					    	
				};	
			 });
	}
	
	private void cleanup() {
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

//				for (Tag tag: tagDao.listAll()) {
//					tagDao.delete(tag);
//				}
//				
//				for (Topic topic: topicDao.listAll()) {
//					topicDao.delete(topic);
//				}
				
				for (Lecture lecture: lectureDao.listAll()) {
					lectureDao.delete(lecture);
				}
			}
		});
		
		
		
		
	}

}
