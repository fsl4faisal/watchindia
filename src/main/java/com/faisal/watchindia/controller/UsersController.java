package com.faisal.watchindia.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.faisal.watchindia.constants.Enabled;
import com.faisal.watchindia.domain.Users;
import com.faisal.watchindia.service.UsersService;

@Controller
@SessionAttributes("userController")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	
	@RequestMapping(value={"user/registration"},method=RequestMethod.GET)
	public String setupForm(Map<String,Object> map){
		System.out.println("Setting up form in /userRegistration");
		map.put("user", new Users());
		return "userRegistration";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addUser(@Valid Users user,BindingResult result,SessionStatus status,Map<String,Object> map){
		if(result.hasErrors()){
			System.out.println("it had errors"+result.getAllErrors());
			map.put("user", user);
			map.put("result", result);
			return "userRegistration";
		}else{
			System.out.println("processed successfully");
			usersService.add(user);
			return "redirect:/index";
		}	
	}
	
	@ModelAttribute("enabledList")
	public Enabled[] getEnabled(){
		return Enabled.values();
	}
	
}
