package com.faisal.watchindia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
public class UsersControllerREST {
	
	@Autowired
	private UsersService usersService;
	
	private static final String VIEWS_USER_CREATE_OR_UPDATE_FORM = "users/createOrUpdateUserForm";
	
	/*Return list of users*/
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = { "/users/" }, method = RequestMethod.GET)
	public String getAllUsers(Map<String,Object> map) {
		
		List<Users> usersListModel = new ArrayList<Users>();
		List<com.faisal.watchindia.dto.Users> usersListDTO = usersService.getAllUsers();

		for (int i = 0; i < usersListDTO.size(); i++) {
			Users target = new Users();
			BeanUtils.copyProperties(usersListDTO.get(i), target);
			usersListModel.add(target);
		}
		map.put("usersList", usersListModel);
		return "user/usersList";
	}
	
	/*Add a new user*/
	
	@RequestMapping(value = { "/users/new" }, method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> map) {
		System.out.println("Setting up form");
		Users users = new Users();
		map.put("users", users);
		map.put("action", "Register User");
		return VIEWS_USER_CREATE_OR_UPDATE_FORM;
	}
	
	@RequestMapping(value = { "/users/new" }, method = RequestMethod.POST)
	public String addUserPost(@Valid Users usersModel, BindingResult result, SessionStatus status,
			Map<String, Object> map) {

		if (result.hasErrors()) {
			map.put("action", "Add User");
			map.put("users", usersModel);
			return VIEWS_USER_CREATE_OR_UPDATE_FORM;
		} else {
			System.out.println("processed successfully");
			com.faisal.watchindia.dto.Users usersDTO = new com.faisal.watchindia.dto.Users();
			BeanUtils.copyProperties(usersModel, usersDTO);
			usersService.add(usersDTO);
			return "redirect:/users/"+usersModel.getId();
		}
	}

	/*Edit the user*/
	
	@RequestMapping(value = { "/users/{id}/edit" }, method = RequestMethod.GET)
	public String setupEditForm(@PathVariable("id") int id, Map<String, Object> map) {
		System.out.println("Setting up form:");
		Users usersModel = new Users();
		BeanUtils.copyProperties(usersService.getUserDetails(id), usersModel);
		map.put("users", usersModel);
		map.put("action", "Edit User");
		return VIEWS_USER_CREATE_OR_UPDATE_FORM;
	}
	
	@RequestMapping(value = { "/users/{id}/edit" }, method = RequestMethod.POST)
	public String updateUserPost(@PathVariable("id") int id, @RequestParam("password") String password,
			@Valid Users usersModel, BindingResult result, SessionStatus status, Map<String, Object> map) {

		if (result.hasErrors()) {
			System.out.println("it had errors" + result.getAllErrors());
			map.put("action", "Edit User");
			map.put("users", usersModel);
			return VIEWS_USER_CREATE_OR_UPDATE_FORM;
		} else {
			System.out.println("processed successfully");
			com.faisal.watchindia.dto.Users usersDTO = new com.faisal.watchindia.dto.Users();
			BeanUtils.copyProperties(usersModel, usersDTO);
			usersService.edit(usersDTO);
			return "redirect:/users/"+usersModel.getId();
		}
	}

	/*Delete a user*/
	@RequestMapping(value = { "/users/{id}" }, method = RequestMethod.DELETE)
	public String deleteUserForm(@PathVariable("id") int id) {
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
