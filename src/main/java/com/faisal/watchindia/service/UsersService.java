package com.faisal.watchindia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.faisal.watchindia.dto.Users;

@Service
public interface UsersService {
	void add(Users users);
	void edit(Users users);
	void delete(int id);
	Users getUserDetails(int id);
	List<Users> getAllUsers();
}
