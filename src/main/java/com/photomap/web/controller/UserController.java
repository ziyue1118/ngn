package com.photomap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.photomap.web.dao.impl.IUserDao;
import com.photomap.web.model.User;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("mysqldatabase.xml");
		IUserDao userjdbc =(IUserDao) context.getBean("IUserDao");
		List<User> users = userjdbc.findall();
		ModelAndView oMAV = new ModelAndView("user");
		oMAV.addObject("userlist", users);
		return oMAV;
	}
}
