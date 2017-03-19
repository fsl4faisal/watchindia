package com.faisal.watchindia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faisal.watchindia.domain.Users;
import com.faisal.watchindia.service.MoviesService;
import com.faisal.watchindia.service.TvSeriesService;
import com.faisal.watchindia.service.UsersService;

@Controller
public class IndexController {
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	MoviesService moviesService;
	
	@Autowired
	TvSeriesService tvSeriesService;
	
	
	@RequestMapping(value={"/","/index"})
	public String indexPage(Map<String,Object> map){
		
		return "index";
	}
	
	@ModelAttribute("usersList")
	public List<Users> getAllUsers(){
		List<Users> usersList=new ArrayList<Users>();
		usersList=usersService.getAllUsers();
		return usersList;
	}
}
