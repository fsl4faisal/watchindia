package com.faisal.watchindia.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.faisal.watchindia.domain.Movies;
import com.faisal.watchindia.service.MoviesService;

@Controller
public class MoviesController {
	
	@Autowired
	private MoviesService moviesService;
	
	
	/*ADD*/
	@RequestMapping(value={"/movies"},params="add",method=RequestMethod.GET)
	public String setupMoviesAddForm(Map<String,Object> map){
		map.put("action","Add New Movie");
		Movies movies=new Movies();
		map.put("movies",movies);
		return "movies";
	}
	
	@RequestMapping(value={"/movies"},params="add",method=RequestMethod.POST)
	public String addMoviesPost(@Valid Movies movies,BindingResult result,Map<String,Object> map){
		if(result.hasErrors()){
			map.put("action","Add New Movie");
			map.put("movies", movies);
			return "movies";
		}else{
			moviesService.add(movies);
			return "redirect:/index";
		}	
	}
	
	/*EDIT*/
	
	@RequestMapping(value={"/movies"},params="edit",method=RequestMethod.GET)
	public String setupMoviesEditForm(@RequestParam("id") int id, Map<String,Object> map){
		map.put("action","Update Movie Details");
		Movies movies=moviesService.getMovie(id);
		map.put("movies",movies);
		return "movies";
	}
	
	@RequestMapping(value={"/movies"},params="edit",method=RequestMethod.POST)
	public String editMoviesPost(@Valid Movies movies,BindingResult result,Map<String,Object> map){
		if(result.hasErrors()){
			map.put("action","Update Movie Details");
			map.put("movies", movies);
			return "movies";
		}else{
			moviesService.edit(movies);
			return "redirect:/index";
		}	
	}
	
	/*DELETE*/
	
	@RequestMapping(value={"/movies"},params="delete",method=RequestMethod.GET)
	public String setupMoviesDeleteForm(@RequestParam("id") int id, Map<String,Object> map){
		map.put("action","Delete Movie ?");
		Movies movies=moviesService.getMovie(id);
		map.put("movies",movies);
		return "movies";
	}
	
	@RequestMapping(value={"/movies"},params="delete",method=RequestMethod.POST)
	public String deleteMoviesPost(@Valid Movies movies,BindingResult result,Map<String,Object> map){
		if(result.hasErrors()){
			map.put("action","Delete Movie ?");
			map.put("movies", movies);
			return "movies";
		}else{
			moviesService.delete(movies.getId());
			return "redirect:/index";
		}	
	}
	
}
