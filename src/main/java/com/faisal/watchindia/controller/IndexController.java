package com.faisal.watchindia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faisal.watchindia.model.Movies;
import com.faisal.watchindia.model.TvSeries;
import com.faisal.watchindia.model.Users;
import com.faisal.watchindia.service.MoviesService;
import com.faisal.watchindia.service.TvSeriesService;
import com.faisal.watchindia.service.UsersService;

@Controller
public class IndexController {

	@Autowired
	UsersService usersService;

	@Autowired
	MoviesService moviesService;

	@Autowired
	TvSeriesService tvSeriesService;

	@RequestMapping(value = { "/", "/index" })
	public String indexPage(Map<String, Object> map) {

		return "index";
	}

	@ModelAttribute("usersList")
	@Secured("ROLE_ADMIN")
	public List<Users> getAllUsers() {
		List<Users> usersListModel = new ArrayList<Users>();
		List<com.faisal.watchindia.dto.Users> usersListDTO = usersService.getAllUsers();

		for (int i = 0; i < usersListDTO.size(); i++) {
			Users target = new Users();
			BeanUtils.copyProperties(usersListDTO.get(i), target);
			usersListModel.add(target);
		}

		return usersListModel;
	}

	@ModelAttribute("moviesList")
	public List<Movies> getAllMovies() {
		List<Movies> moviesListModel = new ArrayList<Movies>();
		List<com.faisal.watchindia.dto.Movies> moviesListDTO = moviesService.getAllMovies();

		for (int i = 0; i < moviesListDTO.size(); i++) {
			Movies target = new Movies();
			BeanUtils.copyProperties(moviesListDTO.get(i), target);
			moviesListModel.add(target);
		}

		return moviesListModel;
	}

	@ModelAttribute("tvSeriesList")
	public List<TvSeries> getAllTvSeries() {
		List<TvSeries> tvSeriesListModel = new ArrayList<TvSeries>();
		List<com.faisal.watchindia.dto.TvSeries> tvSeriesListDTO = tvSeriesService.getAllTvSeries();

		for (int i = 0; i < tvSeriesListDTO.size(); i++) {
			TvSeries target = new TvSeries();
			BeanUtils.copyProperties(tvSeriesListDTO.get(i), target);
			tvSeriesListModel.add(target);
		}

		return tvSeriesListModel;
	}

}
