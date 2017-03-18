package com.faisal.watchindia.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faisal.watchindia.domain.UserDetails;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory session;
	@Override
	public void add(UserDetails user) {
		session.getCurrentSession().save(user);
	}

	@Override
	public void edit(UserDetails user) {
		session.getCurrentSession().update(user);
		
	}

	@Override
	public void delete(int userId) {
		session.getCurrentSession().delete(getUserDetails(userId));
		
	}

	@Override
	public UserDetails getUserDetails(int userId) {
		return (UserDetails)session.getCurrentSession().get(UserDetails.class, userId);
	}

	@Override
	public List getAllUsers() {
		return session.getCurrentSession().createQuery("from UserDetails").list();
	}

}
