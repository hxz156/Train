package com.mercury.spring_mvc_demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// GET /greet -> HelloController

@Controller
@RequestMapping(value="/greet") // means this controller handle /greet
public class HelloController {
	
//	// method handle GET request:
//	@RequestMapping(method=RequestMethod.GET)
//	public String hello() {
//		// return jsp file, only type "hello", viewResolver receive "hello"
//		// will find file: hello.jsp
//		return "hello"; // view name
//	}
	
	//====================================================================
	
//	// 1. pass data to view via request
//	@RequestMapping(method=RequestMethod.GET)
//	public String hello(HttpServletRequest req) {
//		String name = "Bob";
//		// because .jsp file could get Request's attribute, then ...
//		req.setAttribute("name", name);
//		return "hello"; // view name
//	}
	
	//====================================================================
	
	// 2. pass data to view via ModelAndView
//		@RequestMapping(method=RequestMethod.GET)
//		public ModelAndView hello() {
//			String name = "Bob";
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("hello");
//			mav.addObject("name", name);
//			return mav;
//		}
		
	//====================================================================
}
















