package com.knits.tms.integr.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.LectureSearchDto;
import com.knits.tms.config.GenericTransactionalTest;
import com.knits.tms.dao.LectureDao;
import com.knits.tms.model.Lecture;
import com.knits.tms.service.LectureService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class LectureServiceTest  extends GenericTransactionalTest {
	
	@Autowired
	private LectureService lectureService;
	
	@Autowired
	private LectureDao lectureDao;
	
	@Before
	public void init() {	
		
		 super.init();
		 
		 cleanup();
		
	}


@Test
public void testSave() {
	transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
		@Override
		protected void doInTransactionWithoutResult(TransactionStatus status) {
			
			LectureDto lecture = new LectureDto();
			lecture.setTitle("Hoihe");
			lecture.setContent("Heuheu");
			
			
			LectureSearchDto lectureFilterByTitle = new LectureSearchDto();
			lectureFilterByTitle.setTitle("Hoihe");
			
			List<Lecture> lectures = lectureDao.findLectureByFilters(lectureFilterByTitle);
			Assert.assertEquals(0, lectures.size());
			
			lectureService.save(lecture);
			
			lectures = lectureDao.findLectureByFilters(lectureFilterByTitle);
			
			Assert.assertEquals(1, lectures.size());
			
			Lecture lecturemodel = lectures.get(0);
			
			Assert.assertEquals("Hoihe", lecturemodel.getTitle());
			Assert.assertEquals("Heuheu",lecturemodel.getContent());
			
		}
	});
	
}

private void cleanup() {
	
	transactionTemplate.execute(new TransactionCallbackWithoutResult() {				 
		@Override
		protected void doInTransactionWithoutResult(TransactionStatus status) {

			
			for (Lecture lecture: lectureDao.listAll()) {
				lectureDao.delete(lecture);
			}
		}
	});

}
}
		
