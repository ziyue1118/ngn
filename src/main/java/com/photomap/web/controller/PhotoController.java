package com.photomap.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.photomap.web.dao.UserDao;
import com.photomap.web.dao.impl.IPhotoDao;
import com.photomap.web.model.Photo;
@Controller
@RequestMapping("/photo")
public class PhotoController {
	@Autowired
	private UserDao mUserDao;
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ModelAndView handleRequest(@PathVariable("userId") int pUserId) throws Exception{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.photomap.web.model.User oUser = mUserDao.findByUsername(user.getUsername());
		com.photomap.web.model.User oDisplayUser = mUserDao.findById(pUserId);
		ApplicationContext context = new ClassPathXmlApplicationContext("mysqldatabase.xml");
		IPhotoDao pjdbc = (IPhotoDao) context.getBean("IPhotoDao");
		List<Photo> photos = pjdbc.findallbyUserId(pUserId);	
		ModelAndView oMAV = new ModelAndView("photo");
		oMAV.addObject("photos", photos);
		oMAV.addObject("name", oUser.getUsername());
		oMAV.addObject("id", oUser.getId());
		oMAV.addObject("displayUser", oDisplayUser);
		return oMAV;
	}
}
