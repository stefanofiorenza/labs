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
import com.knits.tms.beans.EditionDto;
import com.knits.tms.service.CourseService;
import com.knits.tms.service.EditionService;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/edition")
@Slf4j
public class EditionController {
	
	@Autowired
	private EditionService editionService;
	
	
	 @RequestMapping(value = "/create", method = RequestMethod.GET)
	  public ModelAndView newCourse(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmNewEdition");
		    mav.addObject("EditionDto", new EditionDto());
		    return mav;

	  }

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView moduleProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("EditionDto") EditionDto editionDto) {
		  try {
			  log.info("Reveived edition: "+editionDto.toString());
			  editionService.saveEdition(editionDto);
			  ModelAndView mav = new ModelAndView("frmNewEdition");
			  mav.addObject("msg", "Edition Saved");
			  mav.addObject("EditionDto",editionDto);
			  return mav;
		  }catch (Exception e) {
			  log.error(e.getMessage(),e);
			  ModelAndView mav = new ModelAndView("frmNewEdition");
			  mav.addObject("msg", e.getMessage());
			  mav.addObject("EditionDto",editionDto);
			  return mav;
			  
		  }
		  
		

	  }

}
