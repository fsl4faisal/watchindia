package com.faisal.watchindia.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.faisal.watchindia.domain.Users;

@Repository
public interface UsersDao {
	void add(Users user);
	void edit(Users user);
	void delete(int id);
	Users getUserDetails(int id);
	List getAllUsers();
}
