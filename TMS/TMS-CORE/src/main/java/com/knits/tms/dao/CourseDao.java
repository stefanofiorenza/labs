package com.knits.tms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.stereotype.Repository;

import com.knits.tms.beans.CourseSearchDto;
import com.knits.tms.model.Course;
import com.knits.tms.model.Tag;
import com.knits.tms.model.Topic;
import com.knits.tms.model.Trainer;

@Repository
public class CourseDao extends GenericDao<Course>{

	@Override
	protected Class<Course> getEntityClass() {
		return Course.class;
	}

	public List<Course> findCourseByFilters(CourseSearchDto courseSearchDto) {
		return singleByTagName(courseSearchDto);
		//return singleBySingleField(courseSearchDto);
			
	}

	private List<Course> singleByTagName(CourseSearchDto courseSearchDto){
		CriteriaBuilder cb =getCriteriaBuilder();
		CriteriaQuery<Course> cqueryCourse =cb.createQuery(Course.class);// expected result
		Root<Course> courseTable= cqueryCourse.from(Course.class); // table to query	
		Join<Tag,Course> joinCourseTag = courseTable.join("tags");		
		Predicate filterByTagName=cb.equal(joinCourseTag.get("name"), "title3.AMockTag1");	
		cqueryCourse.select(joinCourseTag).where(filterByTagName);
		TypedQuery<Course> qrtCourses =compileCriteriaQuery(cqueryCourse);		 
		return qrtCourses.getResultList();
	}
	
		
	private List<Course> singleBySingleField(CourseSearchDto courseSearchDto){
		CriteriaBuilder cb =getCriteriaBuilder();
		CriteriaQuery<Course> cqueryCourse =cb.createQuery(Course.class);// expected result
		Root<Course> courseTable= cqueryCourse.from(Course.class); // table to query	
		Predicate filterByTitle=cb.equal(courseTable.get("title"), courseSearchDto.getTitle());	
		cqueryCourse.select(courseTable).where(filterByTitle);
		TypedQuery<Course> qrtCourses =compileCriteriaQuery(cqueryCourse);		 
		return qrtCourses.getResultList();	
		
		
	}
	
	
	
	/*
	 * Query non funziona
	 */
	private List<Course> multipleSelect(){
	
		CriteriaBuilder cb =getCriteriaBuilder();
		CriteriaQuery<Object[]> cqueryCourseJoin =cb.createQuery(Object[].class);// expected result
		
		Root<Course> courseTable= cqueryCourseJoin.from(Course.class); // table to query	
		Root<Tag> tagTable= cqueryCourseJoin.from(Tag.class); // table to query
		Root<Topic> topicTable= cqueryCourseJoin.from(Topic.class); // table to query
		
		cqueryCourseJoin.multiselect(courseTable, tagTable,topicTable);
		
		cqueryCourseJoin
		.where(cb.equal(courseTable.get("tags"), tagTable.get("id")))
		.where(cb.equal(courseTable.get("topics"), topicTable.get("id")))
		.where(cb.equal(topicTable.get("name"),"title1.AMockTopic1"));
		
		TypedQuery<Object[]> qrtCourses =compileCriteriaQuery(Object[].class, cqueryCourseJoin);	
		List<Object[]> resultList =qrtCourses.getResultList();
		
		List<Course> result = new ArrayList<>();
		
		for (Object[] row : resultList) {
			result.add((Course)row[0]);
		}
		
		return result;	
	}
		
	

}
