package com.photomap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import com.photomap.web.dao.impl.IUserDao;
@Controller
@RequestMapping("/photo")
public class PhotoController {
	@Autowired
	private IUserDao mUserDao;
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.photomap.web.model.User oUser = mUserDao.findByUsername(user.getUsername());
		ModelAndView oMAV = new ModelAndView("photo");
		oMAV.addObject("name", oUser.getUsername());
		return oMAV;
	}
}
