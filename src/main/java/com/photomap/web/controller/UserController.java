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
		IUserDao userjdbc =(IUserDao) context.getBean("IUserDao");
		ILocationDao localjdbc = (ILocationDao) context.getBean("ILocationDao");

		// User user1 = userjdbc.findByUsername("chenzy");
		Location local1 = localjdbc.findById(1);
		// Location ll = new Location();

		// ll.setLocationname("Ququ");
		// ll.setLatitude(90.3);
		// ll.setLongitude(34.5);
		// localjdbc.save(ll);
		// List<User> users = userjdbc.findall();
		ModelAndView oMAV = new ModelAndView("user");
		//oMAV.addObject("userlist", user1);
		oMAV.addObject("local", local1);
		return oMAV;
	}
}
