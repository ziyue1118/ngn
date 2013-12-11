package com.photomap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.photomap.web.dao.UserDao;
import com.photomap.web.dao.impl.*;
import com.photomap.web.model.Photo;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao mUserDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.photomap.web.model.User oUser = mUserDao.findByUsername(user.getUsername());
		ApplicationContext context = new ClassPathXmlApplicationContext("mysqldatabase.xml");
		IPhotoDao pjdbc = (IPhotoDao) context.getBean("IPhotoDao");
		List<Photo> photos = pjdbc.findallbyUserId(oUser.getId());		
		ModelAndView oMAV = new ModelAndView("user");
		oMAV.addObject("photos", photos);
		oMAV.addObject("name", oUser.getUsername());
		oMAV.addObject("id", oUser.getId());
		return oMAV;
	}
}
