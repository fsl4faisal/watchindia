package com.faisal.watchindia.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.faisal.watchindia.constants.Enabled;
import com.faisal.watchindia.constants.UserType;
import com.faisal.watchindia.model.Users;
import com.faisal.watchindia.service.UsersService;

@Controller
@SessionAttributes("userController")
@RequestMapping("/admin*")
@Secured("ROLE_ADMIN")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = { "/user" }, method = RequestMethod.GET, params = "add")
	public String setupRegistrationForm(Map<String, Object> map) {
		System.out.println("Setting up form in /userRegistration");
		Users users = new Users();
		map.put("users", users);
		map.put("action", "Register User");
		return "user";
	}

	@RequestMapping(value = { "/user" }, method = RequestMethod.POST, params = "add")
	public String addUserPost(@Valid Users usersModel, BindingResult result, SessionStatus status,
			Map<String, Object> map) {

		if (result.hasErrors()) {
			map.put("action", "Add User");
			map.put("users", usersModel);
			return "user";
		} else {
			System.out.println("processed successfully");
			com.faisal.watchindia.dto.Users usersDTO = new com.faisal.watchindia.dto.Users();
			BeanUtils.copyProperties(usersModel, usersDTO);
			usersService.add(usersDTO);
			return "redirect:/index";
		}
	}

	@RequestMapping(value = { "/user" }, method = RequestMethod.GET, params = "edit")
	public String setupEditForm(@RequestParam("id") int id, Map<String, Object> map) {
		System.out.println("Setting up form in /userRegistration");
		Users usersModel = new Users();
		BeanUtils.copyProperties(usersService.getUserDetails(id), usersModel);
		map.put("users", usersModel);
		map.put("action", "Edit User");
		return "user";
	}

	@RequestMapping(value = { "/user" }, method = RequestMethod.POST, params = "edit")
	public String updateUserPost(@RequestParam("id") int id, @RequestParam("password") String password,
			@Valid Users usersModel, BindingResult result, SessionStatus status, Map<String, Object> map) {

		if (result.hasErrors()) {
			System.out.println("it had errors" + result.getAllErrors());
			map.put("action", "Edit User");
			map.put("users", usersModel);
			return "user";
		} else {
			System.out.println("processed successfully");
			com.faisal.watchindia.dto.Users usersDTO = new com.faisal.watchindia.dto.Users();
			BeanUtils.copyProperties(usersModel, usersDTO);
			usersService.edit(usersDTO);
			return "redirect:/index";
		}
	}

	@RequestMapping(value = { "/user" }, method = RequestMethod.GET, params = "delete")
	public String setupDeleteUserForm(@RequestParam("id") int id, Map<String, Object> map) {
		Users usersModel = new Users();
		BeanUtils.copyProperties(usersService.getUserDetails(id), usersModel);

		map.put("users", usersModel);
		map.put("action", "Delete User ?");
		return "user";
	}

	@RequestMapping(value = { "/user" }, method = RequestMethod.POST, params = "delete")
	public String deleteUserForm(@RequestParam("id") int id) {
		usersService.delete(id);
		return "redirect:/index";
	}

	@ModelAttribute("enabledList")
	public Enabled[] getEnabled() {
		return Enabled.values();
	}

	@ModelAttribute("userTypes")
	public UserType[] getUserTypes() {
		return UserType.values();
	}

}
