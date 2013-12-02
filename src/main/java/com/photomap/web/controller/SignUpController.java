package com.photomap.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.photomap.web.dao.UserDao;
import com.photomap.web.form.PhotoForm;
import com.photomap.web.form.UserForm;
import com.photomap.web.model.User;

@Controller
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
	private UserDao mUserDao;
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView signup(){
//		ModelAndView oMAV = new ModelAndView("home");
//		oMAV.addObject("signupForm", new UserForm());
//		return oMAV;
//	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("signupForm") UserForm pForm, BindingResult result) throws Exception{
		ModelAndView oMAV = new ModelAndView("home");
		User oUser = new User();
		oUser.setUsername(pForm.getUsername());
		oUser.setPassword(pForm.getPassword());
		oUser.setEmail(pForm.getEmail());
		System.out.println(oUser.getEmail());
		mUserDao.save(oUser);
		oMAV.addObject("success", "true");
		return oMAV;
	}

}
