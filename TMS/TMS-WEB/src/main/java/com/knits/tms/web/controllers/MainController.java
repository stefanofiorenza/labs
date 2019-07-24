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
@RequestMapping("/main")
public class MainController {
		
	 @RequestMapping(value = "/index", method = RequestMethod.GET)
	 public ModelAndView newCourse(HttpServletRequest request, HttpServletResponse response) {
		    return  new ModelAndView("view/main/index");	
	 }



}
