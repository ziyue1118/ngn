package com.photomap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception{
		ModelAndView oMAV = new ModelAndView("upload");
		return oMAV;
	}
}
