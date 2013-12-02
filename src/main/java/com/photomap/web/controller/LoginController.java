package com.photomap.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
//	  public ModelAndView printUser() {
//		  ModelAndView oMAV = new ModelAndView();
//		  User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//	      String name = user.getUsername(); //get logged in username
//	 
//	      oMAV.addObject("name", name);
//	      return oMAV;
//	 
//	  }
	 
		@RequestMapping(value="/login", method = RequestMethod.GET)
		public ModelAndView login(){
			ModelAndView oMAV = new ModelAndView("home");
			return oMAV;
		}
	 
		@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
		public ModelAndView loginerror() {
			ModelAndView oMAV = new ModelAndView("home");
			oMAV.addObject("error", "true");
			return oMAV;
	 
		}
//	 
//		@RequestMapping(value="/logout", method = RequestMethod.GET)
//		public String logout(ModelMap model) {
//	 
//			return "login";
//	 
//		}
}
