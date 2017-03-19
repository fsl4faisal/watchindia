package com.faisal.watchindia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.watchindia.dao.UsersDao;
import com.faisal.watchindia.domain.Users;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	@Override
	@Transactional
	public void add(Users user) {
		// TODO Auto-generated method stub
		usersDao.add(user);
		
	}

	@Override
	@Transactional
	public void edit(Users user) {
		// TODO Auto-generated method stub
		usersDao.edit(user);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		usersDao.delete(id);
	}

	@Override
	@Transactional
	public Users getUserDetails(int id) {
		// TODO Auto-generated method stub
		return usersDao.getUserDetails(id);
	}

	@Override
	@Transactional
	public List getAllUsers() {
		// TODO Auto-generated method stub
		return usersDao.getAllUsers();
	}

}
