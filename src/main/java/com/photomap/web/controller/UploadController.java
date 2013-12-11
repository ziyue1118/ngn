package com.photomap.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.photomap.web.dao.PhotoDao;
import com.photomap.web.dao.UserDao;
import com.photomap.web.form.PhotoForm;
import com.photomap.web.model.Photo;


@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired 
	private PhotoDao mPhotoDao;
	@Autowired
	private UserDao mUserDao;

//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView handleRequest() throws Exception{
//		ModelAndView oMAV = new ModelAndView("upload");
//		return oMAV;
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadStudentPage() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.photomap.web.model.User oUser = mUserDao.findByUsername(user.getUsername());
		ModelAndView oMAV = new ModelAndView("upload");
		oMAV.addObject("myform", new PhotoForm());
		oMAV.addObject("userid", oUser.getId());
		oMAV.addObject("name", oUser.getUsername());
		oMAV.addObject("id", oUser.getId());
		return oMAV;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView uploadphoto(@ModelAttribute("myform")PhotoForm pform) throws Exception {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.photomap.web.model.User oUser = mUserDao.findByUsername(user.getUsername());
		Photo p = new Photo();
		p.setDescription(pform.getDescription());
		p.setImgUrl(pform.getImgurl());
		p.setLocationname(pform.getLocationName());
		p.setLatitude(pform.getLatitude());
		p.setLongitude(pform.getLongitude());
		p.setUserId(pform.getUserId());
		p.setDeleted(0);
		mPhotoDao.save(p);
		ModelAndView oMAV = new ModelAndView("redirect:/user");
		oMAV.addObject("name", oUser.getUsername());
		return oMAV;

	}
}
