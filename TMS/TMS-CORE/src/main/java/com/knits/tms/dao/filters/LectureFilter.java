package com.knits.tms.dao.filters;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.knits.tms.beans.LectureSearchDto;
import com.knits.tms.model.Lecture;


public class LectureFilter implements  Specification<Lecture>{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filter == null) ? 0 : filter.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LectureFilter other = (LectureFilter) obj;
		if (filter == null) {
			if (other.filter != null)
				return false;
		} else if (!filter.equals(other.filter))
			return false;
		return true;
	}


	private LectureSearchDto filter;
	
	public LectureFilter(LectureSearchDto filter) {
		this.filter =filter;
	}
	
	
	@Override
	public Predicate toPredicate(Root<Lecture> lectureTable, CriteriaQuery<?> query, CriteriaBuilder cb) {
		query.distinct(true);
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(this.filter.getTitle())) {
			Predicate filterByTitle=cb.equal(lectureTable.get("title"), this.filter.getTitle());			
			predicates.add(filterByTitle);
		}
		
		if(!StringUtils.isEmpty(this.filter.getContent())) {
			Predicate filterByContent=cb.equal(lectureTable.get("content"), this.filter.getContent());			
			predicates.add(filterByContent);
		}
		
		 return cb.and(predicates.toArray(new Predicate[predicates.size()]));		
	}
	
	
	/*
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
	
	*/

}
