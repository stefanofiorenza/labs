package com.knits.tms.integr.test;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import com.knits.tms.beans.LectureSearchDto;
import com.knits.tms.config.GenericTransactionalTest;
import com.knits.tms.dao.LectureDao;
import com.knits.tms.dao.filters.LectureFilter;
import com.knits.tms.model.Lecture;

import lombok.extern.slf4j.Slf4j;

//@Ignore
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class LectureDaoTest extends GenericTransactionalTest {
	
	@Autowired
	private LectureDao lectureDao;
	


	
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
				
		LectureSearchDto lectureFilterByTitle = new LectureSearchDto();
		lectureFilterByTitle.setTitle("titleSaveTest");
		
		List<Lecture> lectures = lectureDao.findAll(new LectureFilter(lectureFilterByTitle));	
		Assert.assertEquals(0, lectures.size());
		
		Lecture lecture = new Lecture();

		lecture.setTitle("titleSaveTest");
		lecture.setContent("contentSaveTest");

		lectureDao.save(lecture);
	
		lectures = lectureDao.findAll(new LectureFilter(lectureFilterByTitle));
		
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
				
		LectureSearchDto lectureFilterByTitle = new LectureSearchDto();
		lectureFilterByTitle.setTitle("title1");
		
		List<Lecture> lectures = lectureDao.findAll(new LectureFilter(lectureFilterByTitle));
		Assert.assertEquals(1, lectures.size());
		
		Lecture lecture =lectures.get(0);	
		Assert.assertNotEquals("testTitle", lecture.getTitle());
		Assert.assertNotEquals("testContent",lecture.getContent());

		lecture.setTitle("testTitle");
		lecture.setContent("testContent");

		lectureDao.save(lecture);
		
		lectureFilterByTitle.setTitle("testTitle");
		lectures = lectureDao.findAll(new LectureFilter(lectureFilterByTitle));
		
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
				
				LectureSearchDto lectureFilterByTitle = new LectureSearchDto();
				lectureFilterByTitle.setTitle("title1");
				
				List<Lecture> lectures = lectureDao.findAll(new LectureFilter(lectureFilterByTitle));			
				Assert.assertEquals(1, lectures.size());
				
				Lecture lecture =lectures.get(0);	

				lectureDao.delete(lecture);
				
				lectures =lectureDao.findAll(new LectureFilter(lectureFilterByTitle));
				Assert.assertEquals(0, lectures.size());
				
				
			}
		});
		
	}
	
	@Test
	public void testListAll() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
			
				List<Lecture> lectures = lectureDao.findAll();
				
				for(Lecture lectur : lectures) {
					log.info("ListAllTest OLDLIST:" + lectur.toString());
				}
				int size = lectures.size();
				
				Lecture lecture = new Lecture();

				lecture.setTitle("titleListAllTest");
				lecture.setContent("contentListAllTest");

				lectureDao.save(lecture);
				
				lectures =lectureDao.findAll();
				Assert.assertEquals(size +1, lectures.size());				
			}
		});
		
	}
	
	@Test
	public void testGetById() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				List<Lecture> lectures = lectureDao.findAll();
				
				Lecture lecture = lectures.get(0);
				Long id = lecture.getId();
				
				Lecture lectureTwo = lectureDao.findById(id).get();
			
				Assert.assertEquals(lecture.getTitle(), lectureTwo.getTitle());
				Assert.assertEquals(lecture.getContent(),lectureTwo.getContent());
			
		}
	});
	
}
	
	@Test
	public void testFindByIds() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				List<Lecture> lectures = lectureDao.findAll();
				
				Lecture lecture = lectures.get(0);
				Long id = lecture.getId();
				
				Lecture lectureTwo = lectures.get(1);
				Long id2 = lectureTwo.getId();
				
				Set<Long> hash_Set = new HashSet<Long>(); 
		        hash_Set.add(id); 
		        hash_Set.add(id2); 
				
				List <Lecture> lecturesByIds = lectureDao.findByIdIn(hash_Set);
							
				Assert.assertTrue(lecturesByIds.contains(lecture));
				Assert.assertTrue(lecturesByIds.contains(lectureTwo));
				
				
			}
		});
		
	}
	
	@Test
	public void testDeleteById() {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
	
				List<Lecture> lectures = lectureDao.findAll();
				
				Lecture lecture = lectures.get(0);
				Long id = lecture.getId();
				
				Lecture lectureToDelete =lectureDao.findById(id).get();
				Assert.assertNotNull(lectureToDelete);
				
				lectureDao.delete(lectureToDelete);
				
				Optional<Lecture> lectureNotFound =lectureDao.findById(id);
				Assert.assertFalse(lectureNotFound.isPresent());
				
				
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
				
				for (Lecture lecture: lectureDao.findAll()) {
					lectureDao.delete(lecture);
				}
			}
		});
		
		
		
		
	}

}
