package com.knits.tms.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.knits.tms.beans.CourseSearchDto;
import com.knits.tms.beans.LectureDto;
import com.knits.tms.model.Course;
import com.knits.tms.model.Lecture;
import com.knits.tms.model.Tag;
import com.knits.tms.model.Topic;

@Repository
public class LectureDao extends GenericDao<Lecture> {

	@Override
	protected Class<Lecture> getEntityClass() {
		// TODO Auto-generated method stub
		return Lecture.class;
	}
	
public List<Lecture> findLectureByFilters(LectureDto lectureDto) {
		
		//return queryWithJpql(courseSearchDto);
		return queryWithCriteriaQuery(lectureDto);					
	}
	
	
	private List<Lecture> queryWithCriteriaQuery(LectureDto lectureDto){
		CriteriaBuilder cb =getCriteriaBuilder();
		CriteriaQuery<Lecture> cqueryCourse =cb.createQuery(Lecture.class);// expected result
		
		Root<Lecture> courseTable= cqueryCourse.from(Lecture.class); // table to query
		
		cqueryCourse.select(courseTable).distinct(true);
		
		if(!StringUtils.isEmpty(lectureDto.getTitle())) {
			Predicate filterByTitle=cb.equal(courseTable.get("title"), lectureDto.getTitle());			
			cqueryCourse.where(filterByTitle);
		}
		
		if(!StringUtils.isEmpty(lectureDto.getContent())) {
			Predicate filterByTitle=cb.equal(courseTable.get("content"), lectureDto.getContent());			
			cqueryCourse.where(filterByTitle);
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
		
		TypedQuery<Lecture> qrtCourses =compileCriteriaQuery(cqueryCourse);		 
		return qrtCourses.getResultList();		
	}
	
	

}
