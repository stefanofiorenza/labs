package com.knits.tms.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.knits.tms.config.AppConfig;
import com.knits.tms.dao.LectureDao;


public class Demo {
public static void main(String[] args) {		
		
		demoDaoImplByName();
				
	}
	
	
	private static void demoDaoImplByName(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		LectureDao cdDao= context.getBean(LectureDao.class);
		//LectureDao cd= cdDao.findById(1l);		
		//System.out.println("Found "+cd.toString());
	}

}
