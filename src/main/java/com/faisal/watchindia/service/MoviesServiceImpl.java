package com.faisal.watchindia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.watchindia.dao.MoviesDao;
import com.faisal.watchindia.domain.Movies;

@Service
public class MoviesServiceImpl implements MoviesService {
	
	@Autowired
	private MoviesDao moviesDao;
	
	@Override
	@Transactional
	public void add(Movies movie) {
		moviesDao.add(movie);
	}

	@Override
	@Transactional
	public void edit(Movies movie) {
		// TODO Auto-generated method stub
		moviesDao.edit(movie);
	}

	@Override
	@Transactional
	public void delete(int movieId) {
		// TODO Auto-generated method stub
		moviesDao.delete(movieId);
	}

	@Override
	@Transactional
	public Movies getMovie(int movieId) {
		// TODO Auto-generated method stub
		return moviesDao.getMovie(movieId);
	}

	@Override
	@Transactional
	public List getAllMovies() {
		// TODO Auto-generated method stub
		return moviesDao.getAllMovies();
	}

}
