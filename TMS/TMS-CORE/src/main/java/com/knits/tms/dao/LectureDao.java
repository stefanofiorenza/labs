package com.knits.tms.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.knits.tms.beans.LectureSearchDto;
import com.knits.tms.model.Lecture;

@Repository
@Transactional
public class LectureDao extends GenericDao<Lecture> {

	@Override
	protected Class<Lecture> getEntityClass() {
		return Lecture.class;
	}
	
public List<Lecture> findLectureByFilters(LectureSearchDto lectureDto) {
		
		//return queryWithJpql(courseSearchDto);
		return queryWithCriteriaQuery(lectureDto);					
	}
	
	
	private List<Lecture> queryWithCriteriaQuery(LectureSearchDto lectureDto){
		CriteriaBuilder cb =getCriteriaBuilder();
		CriteriaQuery<Lecture> cqueryLecture =cb.createQuery(Lecture.class);// expected result
		
		Root<Lecture> lectureTable= cqueryLecture.from(Lecture.class); // table to query
		
		cqueryLecture.select(lectureTable).distinct(true);
		
		if(!StringUtils.isEmpty(lectureDto.getTitle())) {
			Predicate filterByTitle=cb.equal(lectureTable.get("title"), lectureDto.getTitle());			
			cqueryLecture.where(filterByTitle);
		}
		
		if(!StringUtils.isEmpty(lectureDto.getContent())) {
			Predicate filterByContent=cb.equal(lectureTable.get("content"), lectureDto.getContent());			
			cqueryLecture.where(filterByContent);
		}
//		
//		if(courseSearchDto.getPublished()!=null) {
//			Predicate filterByActive=cb.equal(courseTable.get("published"), courseSearchDto.getPublished());
//			cqueryCourse.where(filterByActive);			
//		}
//	
//		
//		if(!CollectionUtils.isEmpty(courseSearchDto.getTags())) {
//			Join<Course,Tag> courseJoinTags =courseTable.join("tags",JoinType.LEFT);
//			Expression<String> tableTagColumnName = courseJoinTags.get("name");
//			Predicate filterByInTagNames = tableTagColumnName.in(courseSearchDto.getTags());
//			cqueryCourse.where(filterByInTagNames);
//		}
//		
//		if(!CollectionUtils.isEmpty(courseSearchDto.getTopics())) {
//			Join<Course,Topic> courseJoinTopics =courseTable.join("topics",JoinType.LEFT);
//			Expression<String> tableTopicColumnName = courseJoinTopics.get("name");
//			Predicate filterByInTopicNames = tableTopicColumnName.in(courseSearchDto.getTopics());
//			cqueryCourse.where(filterByInTopicNames);
//		}
		
		TypedQuery<Lecture> qrtCourses =compileCriteriaQuery(cqueryLecture);		 
		return qrtCourses.getResultList();		
	}
	
	

}
