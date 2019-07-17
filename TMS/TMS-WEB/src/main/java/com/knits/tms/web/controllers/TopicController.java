package com.knits.tms.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knits.tms.beans.TopicDto;
import com.knits.tms.service.TopicService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/topic")
@Slf4j
public class TopicController {
		
	@Autowired
	private TopicService topicService;
	
	
	 @RequestMapping(value = "/create", method = RequestMethod.GET)
	  public ModelAndView newEmployee(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmNewTopic");
		    mav.addObject("TopicDto", new TopicDto());
		    return mav;

	  }

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView lectureProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("TopicDto") TopicDto topic) {
		  log.info("Received topic: "+topic.toString());
		  topicService.save(topic);
		  ModelAndView mav = new ModelAndView("frmNewTopic");
		  mav.addObject("msg", "Topic Saved");
		  mav.addObject("TopicDto",topic);
		  return mav;

	  }
}
