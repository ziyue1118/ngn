package com.photomap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.photomap.web.form.UserForm;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception{
		ModelAndView oMAV = new ModelAndView("home");
		oMAV.addObject("signupForm", new UserForm());
		return oMAV;
	}
}
