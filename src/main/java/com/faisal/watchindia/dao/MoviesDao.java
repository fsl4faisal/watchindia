package com.faisal.watchindia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.faisal.watchindia.domain.Movies;

@Repository
public interface MoviesDao {
	void add(Movies movies);
	void edit(Movies movies);
	void delete(int movieId);
	Movies getMovies(int movieId);
	List<Movies> getAllMovies();
}
