package com.photomap.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.photomap.web.dao.PhotoDao;
import com.photomap.web.dao.UserDao;
import com.photomap.web.dao.impl.IPhotoDao;
import com.photomap.web.dao.impl.IUserDao;
import com.photomap.web.model.Photo;


@Controller
@RequestMapping("/events")
public class EventsController {
	
	@Autowired
	private UserDao mUserDao;
	@Autowired
	private PhotoDao mPhotoDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(@RequestParam(value = "lat", defaultValue = "100.0") double pLat, @RequestParam(value = "lng", defaultValue = "0.0") double pLng) throws Exception{
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.photomap.web.model.User oUser = mUserDao.findByUsername(user.getUsername());
		ApplicationContext context = new ClassPathXmlApplicationContext("mysqldatabase.xml");
		IPhotoDao pjdbc = (IPhotoDao) context.getBean("IPhotoDao");
		IUserDao ujdbc = (IUserDao) context.getBean("IUserDao");
		List<Photo> photos = new ArrayList<Photo>();
		if(pLat == 100.0) photos = pjdbc.findallLatestPhotos();
		else photos = mPhotoDao.findbyLocation(pLat, pLng);
		List<com.photomap.web.model.User> users = new ArrayList<com.photomap.web.model.User>();
		Map<com.photomap.web.model.User, Photo> mapphotos = new HashMap<com.photomap.web.model.User, Photo>();
		for(int i=0;i<photos.size();i++){
			com.photomap.web.model.User tempuser = ujdbc.findById(photos.get(i).getUserId());
			users.add(tempuser);
			mapphotos.put(tempuser,photos.get(i));
		}
		ModelAndView oMAV = new ModelAndView("event");
		oMAV.addObject("mapphotos", mapphotos);
		oMAV.addObject("users", users);
		oMAV.addObject("photos", photos);
		oMAV.addObject("name", oUser.getUsername());
		oMAV.addObject("id", oUser.getId());
		return oMAV;
	}
}
