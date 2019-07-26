package com.knits.tms.dao.filters;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import com.knits.tms.beans.CourseSearchDto;
import com.knits.tms.model.Course;
import com.knits.tms.model.Tag;
import com.knits.tms.model.Topic;

public class CourseFilter implements  Specification<Course>{

	
	private CourseSearchDto filters;
	
	public CourseFilter (CourseSearchDto filters) {
		this.filters=filters;
	}
	
	@Override
	public Predicate toPredicate(Root<Course> courseTable, CriteriaQuery<?> query, CriteriaBuilder cb) {
						
		
		//CriteriaQuery<Course> cqueryCourse =(CriteriaQuery<Course>)query;
	//	cqueryCourse.select(courseTable).distinct(true);
		
		
		query.distinct(true);//otherwise will list a Course for every matching row in join
		
		List<Predicate> predicates = new ArrayList<>();
		 
		if(!StringUtils.isEmpty(this.filters.getTitle())) {
			Predicate filterByTitle=cb.equal(courseTable.get("title"), this.filters.getTitle());			
			predicates.add(filterByTitle);
		}
		
		if(this.filters.getActive()!=null) {
			Predicate filterByActive=cb.equal(courseTable.get("active"), this.filters.getActive());				
			predicates.add(filterByActive);
		}
		
		if(this.filters.getPublished()!=null) {
			Predicate filterByActive=cb.equal(courseTable.get("published"), this.filters.getPublished());			
			predicates.add(filterByActive);
		}
	
		
		if(!CollectionUtils.isEmpty(this.filters.getTags())) {
			Join<Course,Tag> courseJoinTags =courseTable.join("tags",JoinType.LEFT);
			Expression<String> tableTagColumnName = courseJoinTags.get("name");
			Predicate filterByInTagNames = tableTagColumnName.in(this.filters.getTags());			
			predicates.add(filterByInTagNames);
		}
		
		if(!CollectionUtils.isEmpty(this.filters.getTopics())) {
			Join<Course,Topic> courseJoinTopics =courseTable.join("topics",JoinType.LEFT);
			Expression<String> tableTopicColumnName = courseJoinTopics.get("name");
			Predicate filterByInTopicNames = tableTopicColumnName.in(this.filters.getTopics());
			predicates.add(filterByInTopicNames);
		}
	
		 return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

}
