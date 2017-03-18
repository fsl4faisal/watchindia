package com.faisal.watchindia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.watchindia.dao.UserDao;
import com.faisal.watchindia.domain.UserDetails;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public void add(UserDetails user) {
		// TODO Auto-generated method stub
		userDao.add(user);
		
	}

	@Override
	@Transactional
	public void edit(UserDetails user) {
		// TODO Auto-generated method stub
		userDao.edit(user);
	}

	@Override
	@Transactional
	public void delete(int userId) {
		// TODO Auto-generated method stub
		userDao.delete(userId);
	}

	@Override
	@Transactional
	public UserDetails getUserDetails(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUserDetails(userId);
	}

	@Override
	@Transactional
	public List getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

}
