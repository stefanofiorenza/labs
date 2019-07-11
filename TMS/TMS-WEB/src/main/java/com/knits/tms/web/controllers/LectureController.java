package com.knits.tms.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.model.Lecture;
import com.knits.tms.service.LectureService;
import com.knits.tms.util.BeanMappingUtils;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/form")
@Slf4j
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	
	 @RequestMapping(value = "/lecture", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmNewLecture");
		    mav.addObject("LectureDto", new LectureDto());
		    return mav;

	  }

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("LectureDto") LectureDto lecture) {
		  log.info("Reveived lecture: "+lecture.toString());
		  lectureService.save(lecture);
		  ModelAndView mav = new ModelAndView("frmNewLecture");
		  mav.addObject("msg", "Lecture Saved");
		  mav.addObject("LectureDto",lecture);
		  return mav;

	  }

}
