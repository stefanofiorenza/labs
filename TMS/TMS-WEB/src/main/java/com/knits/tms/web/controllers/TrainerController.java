package com.knits.tms.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knits.tms.beans.LectureDto;
import com.knits.tms.beans.LectureSearchDto;
import com.knits.tms.beans.TrainerDto;
import com.knits.tms.beans.TrainerSearchDto;
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
	  
	  @RequestMapping(value = "/search", method = RequestMethod.GET)
	  public ModelAndView trainerSearch(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmSearchTrainer");
		    mav.addObject("TrainerSearchDto", new TrainerSearchDto());
		    return mav;

	  }
	 
	  @RequestMapping(value = "/search", method = RequestMethod.POST)
	  public ModelAndView trainerSearchProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("trainers") TrainerSearchDto trainer) {
		  List<TrainerDto> trainersFound = trainerService.findTrainerByFilters(trainer);
		  List<TrainerDto> trainersFoundByIdCode = trainerService.findTrainerByFilters(trainer);
		  ModelAndView mav = new ModelAndView("frmSearchTrainer");
		  mav.addObject("TrainerSearchDto", new TrainerSearchDto());
		  mav.addObject("msg", "Trainer search submitted");
		  mav.addObject("trainers",trainersFound);
		  return mav;

	  }
	  
	  
	  @RequestMapping(value = "/edit", method = RequestMethod.GET)
	  public ModelAndView trainEdit(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmEditTrainer");
		    mav.addObject("TrainerDto", new TrainerDto());
		    return mav;

	  }

}
