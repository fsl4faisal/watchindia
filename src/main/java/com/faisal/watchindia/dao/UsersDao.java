package com.faisal.watchindia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.faisal.watchindia.domain.Users;

@Repository
public interface UsersDao {
	void add(Users users);
	void edit(Users users);
	void delete(int id);
	Users getUserDetails(int id);
	List<Users> getAllUsers();
}
