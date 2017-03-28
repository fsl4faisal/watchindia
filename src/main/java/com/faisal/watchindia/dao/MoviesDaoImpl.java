package com.faisal.watchindia.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faisal.watchindia.domain.Movies;

@Repository
public class MoviesDaoImpl implements MoviesDao {
	
	@Autowired
	private SessionFactory session;
	@Override
	public void add(Movies movie) {
		session.getCurrentSession().save(movie);
		
	}

	@Override
	public void edit(Movies movie) {
		session.getCurrentSession().update(movie);
		
	}

	@Override
	public void delete(int movieId) {
		session.getCurrentSession().delete(getMovies(movieId));
		
	}

	@Override
	public Movies getMovies(int movieId) {
		return (Movies)session.getCurrentSession().get(Movies.class,movieId);
	}

	@Override
	public List<Movies> getAllMovies() {
		return session.getCurrentSession().createQuery("from Movies").list();
	}

}
