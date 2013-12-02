package com.photomap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.photomap.web.form.*;
import com.photomap.web.model.Photo;
import com.photomap.web.dao.impl.IPhotoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired 
	private IPhotoDao mPhotoDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception{
		ModelAndView oMAV = new ModelAndView("upload");
		return oMAV;
	}

	@RequestMapping(value = "/photo", method = RequestMethod.POST)
	public ModelAndView uploadphoto(@ModelAttribute("myform")PhotoForm pform, BindingResult result) throws Exception {
		Photo p = new Photo();
		p.setDescription(pform.getDescription());
		p.setImgUrl(pform.getImgUrl());
		p.setLocationname(pform.getLocationName());
		p.setLatitude(pform.getLatitude());
		p.setLongitude(pform.getLongitude());
		p.setUserId(pform.getUserId());
		mPhotoDao.save(p);
		ModelAndView oMAV = new ModelAndView("upload");
		System.out.println("successful");
	    return oMAV;

	}
}
