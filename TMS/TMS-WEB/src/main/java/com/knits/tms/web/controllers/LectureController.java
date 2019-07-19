package com.knits.tms.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.LectureSearchDto;
import com.knits.tms.model.Lecture;
import com.knits.tms.service.LectureService;
import com.knits.tms.util.BeanMappingUtils;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/lecture")
@Slf4j
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	
	 @RequestMapping(value = "/create", method = RequestMethod.GET)
	  public ModelAndView newLecture(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmNewLecture");
		    mav.addObject("LectureDto", new LectureDto());
		    return mav;

	  }

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView lectureProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("LectureDto") LectureDto lecture) {
		  log.info("Reveived lecture: "+lecture.toString());
		  lectureService.save(lecture);
		  ModelAndView mav = new ModelAndView("frmNewLecture");
		  mav.addObject("msg", "Lecture Saved");
		  mav.addObject("LectureDto",lecture);
		  return mav;

	  }

		 @RequestMapping(value = "/search", method = RequestMethod.GET)
		  public ModelAndView lectureSearch(HttpServletRequest request, HttpServletResponse response) {
			    ModelAndView mav = new ModelAndView("frmSearchLectures");
			    mav.addObject("LectureSearchDto", new LectureSearchDto());
			    return mav;

		  }
		 
		  @RequestMapping(value = "/search", method = RequestMethod.POST)
		  public ModelAndView lectureSearchProcess(HttpServletRequest request, HttpServletResponse response,
		  @ModelAttribute("lectures") LectureSearchDto lecture) {
			  log.info("Reveived lectures filters: "+lecture.toString());
			  List<LectureDto> lecturesfound = lectureService.findLectureByFilters(lecture);
			  ModelAndView mav = new ModelAndView("frmSearchLectures");
			  mav.addObject("LectureSearchDto", new LectureSearchDto());
			  mav.addObject("msg", "Lecture search submitted");
			  mav.addObject("lectures",lecturesfound);
			  return mav;

		  }
}
