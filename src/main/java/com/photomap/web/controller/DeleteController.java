package com.photomap.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.photomap.web.dao.PhotoDao;
import com.photomap.web.dao.UserDao;

@Controller
@RequestMapping("/delete")
public class DeleteController {
	@Autowired
	private PhotoDao mPhotoDao;
	@Autowired
	private UserDao mUserDao;
	
	@RequestMapping(value = "/{photoId}", method = RequestMethod.GET)
	public ModelAndView handleRequest(@PathVariable("photoId") int pPhotoId) throws Exception{
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//com.photomap.web.model.User oUser = mUserDao.findByUsername(user.getUsername());
		mPhotoDao.deletePhoto(pPhotoId);
		ModelAndView oMAV = new ModelAndView("redirect:/user");
		return oMAV;
	}
}
