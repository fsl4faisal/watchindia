package com.faisal.watchindia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.faisal.watchindia.dto.Movies;

@Service
public interface MoviesService {
	void add(Movies movies);
	void edit(Movies movies);
	void delete(int moviesId);
	Movies getMovies(int moviesId);
	List<Movies> getAllMovies();
}
