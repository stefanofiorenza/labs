package com.knits.tms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.knits.tms.beans.CourseSearchDto;
import com.knits.tms.model.Course;
import com.knits.tms.model.Tag;
import com.knits.tms.model.Topic;
import com.knits.tms.model.Trainer;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CourseDao extends GenericDao<Course>{

	@Override
	protected Class<Course> getEntityClass() {
		return Course.class;
	}

	public List<Course> findCourseByFilters(CourseSearchDto courseSearchDto) {
		
		//return queryWithJpql(courseSearchDto);
		return queryWithCriteriaQuery(courseSearchDto);					
	}
	
	
	private List<Course> queryWithCriteriaQuery(CourseSearchDto courseSearchDto){
		CriteriaBuilder cb =getCriteriaBuilder();
		CriteriaQuery<Course> cqueryCourse =cb.createQuery(Course.class);// expected result
		
		Root<Course> courseTable= cqueryCourse.from(Course.class); // table to query
		
		cqueryCourse.select(courseTable).distinct(true);
		
		if(!StringUtils.isEmpty(courseSearchDto.getTitle())) {
			Predicate filterByTitle=cb.equal(courseTable.get("title"), courseSearchDto.getTitle());			
			cqueryCourse.where(filterByTitle);
		}
		
		if(courseSearchDto.getActive()!=null) {
			Predicate filterByActive=cb.equal(courseTable.get("active"), courseSearchDto.getActive());	
			cqueryCourse.where(filterByActive);
		}
		
		if(courseSearchDto.getPublished()!=null) {
			Predicate filterByActive=cb.equal(courseTable.get("published"), courseSearchDto.getPublished());
			cqueryCourse.where(filterByActive);			
		}
	
		
		if(!CollectionUtils.isEmpty(courseSearchDto.getTags())) {
			Join<Course,Tag> courseJoinTags =courseTable.join("tags",JoinType.LEFT);
			Expression<String> tableTagColumnName = courseJoinTags.get("name");
			Predicate filterByInTagNames = tableTagColumnName.in(courseSearchDto.getTags());
			cqueryCourse.where(filterByInTagNames);
		}
		
		if(!CollectionUtils.isEmpty(courseSearchDto.getTopics())) {
			Join<Course,Topic> courseJoinTopics =courseTable.join("topics",JoinType.LEFT);
			Expression<String> tableTopicColumnName = courseJoinTopics.get("name");
			Predicate filterByInTopicNames = tableTopicColumnName.in(courseSearchDto.getTopics());
			cqueryCourse.where(filterByInTopicNames);
		}
		
		TypedQuery<Course> qrtCourses =compileCriteriaQuery(cqueryCourse);		 
		return qrtCourses.getResultList();		
	}
	
	
		
		
	private List<Course> queryWithJpql(CourseSearchDto courseSearchDto){
		
		StringBuffer queryAsSbuffer = new StringBuffer("select distinct c from Course c");
		
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
	    List<String> whereClause = new ArrayList<String>();
	    
		if(!CollectionUtils.isEmpty(courseSearchDto.getTags())) {
			queryAsSbuffer.append(" left join c.tags tg");
			whereClause.add(" tg.name in (:tagnames) ");
			paramaterMap.put("tagnames", courseSearchDto.getTags());
		}
		
		if(!CollectionUtils.isEmpty(courseSearchDto.getTopics())) {
			queryAsSbuffer.append(" left join c.topics tpc");
			whereClause.add(" tpc.name in (:topicnames) ");			
			paramaterMap.put("topicnames", courseSearchDto.getTags());
		}
		
		if(!StringUtils.isEmpty(courseSearchDto.getTitle())) {
			whereClause.add(" c.title=:title");
			paramaterMap.put("title", courseSearchDto.getTitle());
		}

		if(courseSearchDto.getActive()!=null) {
			whereClause.add(" c.active=:active");
			paramaterMap.put("active", courseSearchDto.getActive());
		}
		
		if(courseSearchDto.getPublished()!=null) {
			whereClause.add(" c.published=:published");
			paramaterMap.put("published", courseSearchDto.getPublished());
		}
				
		queryAsSbuffer.append(" where " + org.apache.commons.lang3.StringUtils.join(whereClause, " and "));	
		
		String queryAsJpql =queryAsSbuffer.toString();
		log.info("Jpql generated : {}",queryAsJpql);
		
		TypedQuery<Course> qryCourses =createQuery(queryAsJpql);	
		
		for(String key :paramaterMap.keySet()) {
			qryCourses.setParameter(key, paramaterMap.get(key));
		}
		
			 
		return qryCourses.getResultList();		
	}
	
	
	
}
