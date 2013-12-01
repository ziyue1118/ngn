package com.photomap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.photomap.web.dao.impl.*;
import com.photomap.web.model.*;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("mysqldatabase.xml");
		//IUserDao userjdbc =(IUserDao) context.getBean("IUserDao");
		IPhotoDao pjdbc = (IPhotoDao) context.getBean("IPhotoDao");

		// User user1 = userjdbc.findByUsername("chenzy");
		// Photo p = new Photo();
		// p.setDescription("walawala");
		// p.setImgUrl("file//nimaba.jpg");
		// p.setLocationname("earth");
		// p.setLatitude(90.5);
		// p.setLongitude(85.1);
		// p.setUserId(2);
		// pjdbc.save(p);
		List<Photo> photos = pjdbc.findallPhotos();		
		ModelAndView oMAV = new ModelAndView("user");
		//oMAV.addObject("userlist", user1);
		oMAV.addObject("photos", photos);
		return oMAV;
	}
}
