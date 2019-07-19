package com.knits.tms.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.knits.tms.beans.TagDto;
import com.knits.tms.beans.TopicDto;
import com.knits.tms.service.TagService;
import com.knits.tms.service.TopicService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/tag")
@Slf4j
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	
	 @RequestMapping(value = "/create", method = RequestMethod.GET)
	  public ModelAndView newTag(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmNewTag");
		    mav.addObject("TagDto", new TagDto());
		    return mav;

	  }

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView tagProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("TagDto") TagDto tag) {
		  log.info("Received topic: "+tag.toString());
		  tagService.save(tag);
		  ModelAndView mav = new ModelAndView("frmNewTag");
		  mav.addObject("msg", "Tag Saved");
		  mav.addObject("TagDto",tag);
		  return mav;

	  }

}
