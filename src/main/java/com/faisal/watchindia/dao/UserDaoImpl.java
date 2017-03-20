package com.faisal.watchindia.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faisal.watchindia.domain.Users;

@Repository
public class UserDaoImpl implements UsersDao {
	
	@Autowired
	private SessionFactory session;
	@Override
	public void add(Users user) {
		session.getCurrentSession().save(user);
	}

	@Override
	public void edit(Users user) {
		session.getCurrentSession().update(user);
		
	}

	@Override
	public void delete(int id) {
		session.getCurrentSession().delete(getUserDetails(id));
		
	}

	@Override
	public Users getUserDetails(int id) {
		return (Users)session.getCurrentSession().get(Users.class, id);
	}

	@Override
	public List<Users> getAllUsers() {
		return session.getCurrentSession().createQuery("from Users").list();
	}

}
