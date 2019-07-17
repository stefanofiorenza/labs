package com.knits.tms.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.knits.tms.beans.EmployeeDto;
import com.knits.tms.service.EmployeeService;


import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	 @RequestMapping(value = "/create", method = RequestMethod.GET)
	  public ModelAndView newEmployee(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("frmNewEmployee");
		    mav.addObject("EmployeeDto", new EmployeeDto());
		    return mav;

	  }

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView lectureProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("EmployeeDto") EmployeeDto employee) {
		  log.info("Reveived lecture: "+employee.toString());
		  employeeService.saveEmployee(employee);
		  ModelAndView mav = new ModelAndView("frmNewEmployee");
		  mav.addObject("msg", "Employee Saved");
		  mav.addObject("EmployeeDto",employee);
		  return mav;

	  }

}
