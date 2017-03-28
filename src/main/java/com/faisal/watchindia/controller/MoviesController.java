package com.faisal.watchindia.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.faisal.watchindia.model.Movies;
import com.faisal.watchindia.service.MoviesService;

@Controller
@RequestMapping("/admin*")
@Secured("ROLE_ADMIN")
public class MoviesController {

	@Autowired
	private MoviesService moviesService;

	/* ADD */
	@RequestMapping(value = { "/movies" }, method = RequestMethod.GET, params = "add")
	public String setupMoviesAddForm(Map<String, Object> map) {
		map.put("action", "Add New Movie");
		Movies movies = new Movies();
		map.put("movies", movies);
		return "movies";
	}

	@RequestMapping(value = { "/movies" }, method = RequestMethod.POST, params = "add")
	public String addMoviesPost(@Valid Movies moviesModel, BindingResult result, Map<String, Object> map) {
		if (result.hasErrors()) {
			map.put("action", "Add New Movie");
			map.put("movies", moviesModel);
			return "movies";
		} else {
			com.faisal.watchindia.dto.Movies moviesDTO = new com.faisal.watchindia.dto.Movies();
			BeanUtils.copyProperties(moviesModel, moviesDTO);
			moviesService.add(moviesDTO);
			return "redirect:/index";
		}
	}

	/* EDIT */

	@RequestMapping(value = { "/movies" }, params = "edit", method = RequestMethod.GET)
	public String setupMoviesEditForm(@RequestParam("id") int id, Map<String, Object> map) {
		map.put("action", "Update Movie Details");
		com.faisal.watchindia.dto.Movies moviesDTO = moviesService.getMovies(id);
		Movies moviesModel = new Movies();
		BeanUtils.copyProperties(moviesDTO, moviesModel);
		map.put("movies", moviesModel);
		return "movies";
	}

	@RequestMapping(value = { "/movies" }, params = "edit", method = RequestMethod.POST)
	public String editMoviesPost(@Valid Movies moviesModel, BindingResult result, Map<String, Object> map) {
		if (result.hasErrors()) {
			map.put("action", "Update Movie Details");
			map.put("movies", moviesModel);
			return "movies";
		} else {
			com.faisal.watchindia.dto.Movies moviesDTO = new com.faisal.watchindia.dto.Movies();
			BeanUtils.copyProperties(moviesModel, moviesDTO);
			moviesService.edit(moviesDTO);
			return "redirect:/index";
		}
	}

	/* DELETE */

	@RequestMapping(value = { "/movies" }, params = "delete", method = RequestMethod.GET)
	public String setupMoviesDeleteForm(@RequestParam("id") int id, Map<String, Object> map) {
		map.put("action", "Delete Movie ?");
		Movies moviesModel = new Movies();
		com.faisal.watchindia.dto.Movies moviesDTO = moviesService.getMovies(id);

		BeanUtils.copyProperties(moviesDTO, moviesModel);
		map.put("movies", moviesModel);
		return "movies";
	}

	@RequestMapping(value = { "/movies" }, method = RequestMethod.DELETE,params="delete")
	public String deleteMoviesPost(@RequestParam("id") int id) {
		moviesService.delete(id);
		return "redirect:/index";
	}

}
