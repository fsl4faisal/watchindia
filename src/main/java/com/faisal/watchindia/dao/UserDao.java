package com.faisal.watchindia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.faisal.watchindia.domain.UserDetails;

@Repository
public interface UserDao {
	void add(UserDetails user);
	void edit(UserDetails user);
	void delete(int userId);
	UserDetails getUserDetails(int userId);
	List getAllUsers();
}
