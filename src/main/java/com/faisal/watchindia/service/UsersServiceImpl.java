package com.faisal.watchindia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.watchindia.dao.UsersDao;
import com.faisal.watchindia.dto.Users;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersDao usersDao;
		
	
	
	@Override
	@Transactional
	public void add(Users usersDTO) {
		com.faisal.watchindia.domain.Users usersDomain=new com.faisal.watchindia.domain.Users();
		usersDTO.setPassword(usersDTO.getUsername());
		BeanUtils.copyProperties(usersDTO, usersDomain);
		usersDao.add(usersDomain);
		
	}

	@Override
	@Transactional
	public void edit(Users usersDTO) {
		com.faisal.watchindia.domain.Users usersDomain=new com.faisal.watchindia.domain.Users();
		BeanUtils.copyProperties(usersDTO, usersDomain);
		usersDao.edit(usersDomain);
	}

	@Override
	@Transactional
	public void delete(int id) {
		usersDao.delete(id);
	}

	@Override
	@Transactional
	public Users getUserDetails(int id) {
		com.faisal.watchindia.domain.Users usersDomain=new com.faisal.watchindia.domain.Users();
		usersDomain=usersDao.getUserDetails(id);
		Users usersDTO=new Users();
		BeanUtils.copyProperties(usersDomain, usersDTO);
		return usersDTO;
	}

	@Override
	@Transactional
	public List<Users> getAllUsers() {
		List<com.faisal.watchindia.domain.Users> usersListDomain=usersDao.getAllUsers();
		List<Users> usersListDTO=new ArrayList<Users>();
		
		for(int i=0;i<usersListDomain.size();i++){
			Users target=new Users();
			BeanUtils.copyProperties(usersListDomain.get(i), target);
			usersListDTO.add(target);
		}		
		return usersListDTO;
	}

}
