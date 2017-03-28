package com.faisal.watchindia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.watchindia.dao.MoviesDao;
import com.faisal.watchindia.dto.Movies;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	private MoviesDao moviesDao;

	@Override
	@Transactional
	public void add(Movies moviesDTO) {
		com.faisal.watchindia.domain.Movies moviesDomain = new com.faisal.watchindia.domain.Movies();
		BeanUtils.copyProperties(moviesDTO, moviesDomain);
		moviesDao.add(moviesDomain);
	}

	@Override
	@Transactional
	public void edit(Movies moviesDTO) {
		com.faisal.watchindia.domain.Movies moviesDomain = new com.faisal.watchindia.domain.Movies();
		BeanUtils.copyProperties(moviesDTO, moviesDomain);
		moviesDao.edit(moviesDomain);
	}

	@Override
	@Transactional
	public void delete(int movieId) {

		moviesDao.delete(movieId);
	}

	@Override
	@Transactional
	public Movies getMovies(int movieId) {
		Movies moviesDTO = new Movies();
		BeanUtils.copyProperties(moviesDao.getMovies(movieId), moviesDTO);
		return moviesDTO;
	}

	@Override
	@Transactional
	public List<Movies> getAllMovies() {
		List<Movies> moviesListDTO = new ArrayList<Movies>();
		List<com.faisal.watchindia.domain.Movies> moviesListDomain = moviesDao.getAllMovies();

		for (int i = 0; i < moviesListDomain.size(); i++) {
			Movies target = new Movies();
			BeanUtils.copyProperties(moviesListDomain.get(i), target);
			moviesListDTO.add(target);
		}

		return moviesListDTO;
	}

}
