package com.knits.tms.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knits.tms.beans.ModuleDto;
import com.knits.tms.service.ModuleService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/module")
@Slf4j
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	
	
	 @RequestMapping(value = "/create", method = RequestMethod.GET)
	  public ModelAndView newModule(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmNewModule");
		    mav.addObject("ModuleDto", new ModuleDto());
		    return mav;

	  }

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView moduleProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("ModuleDto") ModuleDto moduleDto) {
		  log.info("Reveived lecture: "+moduleDto.toString());
		  moduleService.saveModule(moduleDto);
		  ModelAndView mav = new ModelAndView("frmNewModule");
		  mav.addObject("msg", "Module Saved");
		  mav.addObject("ModuleDto",moduleDto);
		  return mav;

	  }
	  
	  


}
