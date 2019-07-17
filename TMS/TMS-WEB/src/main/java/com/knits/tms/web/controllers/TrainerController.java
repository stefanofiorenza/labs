package com.knits.tms.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knits.tms.beans.TrainerDto;
import com.knits.tms.service.TrainerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/trainer")
@Slf4j
public class TrainerController {
	@Autowired
	private TrainerService trainerService;
	
	
	 @RequestMapping(value = "/create", method = RequestMethod.GET)
	  public ModelAndView newLecture(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmNewTrainer");
		    mav.addObject("TrainerDto", new TrainerDto());
		    return mav;

	  }

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView lectureProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("TrainerDto") TrainerDto trainer) {
		  log.info("Received trainer: "+trainer.toString());
		  trainerService.save(trainer);
		  ModelAndView mav = new ModelAndView("frmNewTrainer");
		  mav.addObject("msg", "Trainer Saved");
		  mav.addObject("TrainerDto",trainer);
		  return mav;

	  }

}
