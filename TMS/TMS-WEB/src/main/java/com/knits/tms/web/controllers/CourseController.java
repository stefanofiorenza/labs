package com.knits.tms.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knits.tms.beans.CourseDto;

import com.knits.tms.service.CourseService;


import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/course")
@Slf4j
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	 @RequestMapping(value = "/create", method = RequestMethod.GET)
	  public ModelAndView newCourse(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmNewCourse");
		    mav.addObject("CourseDto", new CourseDto());
		    return mav;

	  }

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView moduleProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("CourseDto") CourseDto courseDto) {
		  log.info("Reveived lecture: "+courseDto.toString());
		  courseService.saveCourse(courseDto);
		  ModelAndView mav = new ModelAndView("frmNewCourse");
		  mav.addObject("msg", "Course Saved");
		  mav.addObject("CourseDto",courseDto);
		  return mav;

	  }

}
