package com.ydl.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ydl.springboot.entity.User;
import com.ydl.springboot.server.UserService;

@Controller
public class HomeController {
	
	
	public static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired 
	UserService postServerImpl;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@RequestMapping(value="/home/{name}")
	@ResponseBody
	public   List<User> home1(@PathVariable String name){
		logger.info("日志打印出来了");
		return   postServerImpl.getUsers(name);
	}
	
	
	@RequestMapping(value="/index/{name}")
	public   ModelAndView index(@PathVariable String name){
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		view.addObject("name", name);
		System.out.println(request.getAttribute("ydl"));
		return  view;
	}
	
	 
	
	 
}
 