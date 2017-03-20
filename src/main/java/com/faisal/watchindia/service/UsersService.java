package com.faisal.watchindia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.faisal.watchindia.domain.Users;

@Service
public interface UsersService {
	void add(Users user);
	void edit(Users user);
	void delete(int id);
	Users getUserDetails(int id);
	List<Users> getAllUsers();
}
