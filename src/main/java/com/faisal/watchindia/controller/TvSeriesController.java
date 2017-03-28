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

import com.faisal.watchindia.dto.TvSeries;
import com.faisal.watchindia.service.TvSeriesService;

@Controller
@RequestMapping("/admin*")
@Secured("ROLE_ADMIN")
public class TvSeriesController {

	@Autowired
	TvSeriesService tvSeriesService;

	/* ADD */

	@RequestMapping(value = { "/tvSeries" }, method = RequestMethod.GET, params = "add")
	public String setupTvSeriesAddForm(Map<String, Object> map) {
		TvSeries tvSeries = new TvSeries();
		map.put("message", "Add Episode");
		map.put("tvSeries", tvSeries);
		return "tvSeries";
	}

	@RequestMapping(value = { "/tvSeries" }, method = RequestMethod.POST, params = "add")
	public String tvSeriesAddPost(@Valid TvSeries tvSeriesModel, BindingResult result, Map<String, Object> map) {
		if (result.hasErrors()) {
			map.put("message", "Add Episode");
			map.put("tvSeries", tvSeriesModel);
			return "tvSeries";
		} else {
			com.faisal.watchindia.dto.TvSeries tvSeriesDTO = new com.faisal.watchindia.dto.TvSeries();
			BeanUtils.copyProperties(tvSeriesModel, tvSeriesDTO);
			tvSeriesService.add(tvSeriesDTO);
			return "redirect:/index";
		}
	}

	/* EDIT */

	@RequestMapping(value = { "/tvSeries" }, method = RequestMethod.GET, params = "edit")
	public String setupTvSeriesEditForm(@RequestParam("id") int id, Map<String, Object> map) {
		TvSeries tvSeries = tvSeriesService.getTvSeries(id);
		map.put("message", "Edit Episode");
		map.put("tvSeries", tvSeries);
		return "tvSeries";
	}

	@RequestMapping(value = { "/tvSeries" }, method = RequestMethod.POST, params = "edit")
	public String tvSeriesEditPost(@Valid TvSeries tvSeriesModel, BindingResult result, Map<String, Object> map) {
		if (result.hasErrors()) {
			map.put("message", "Edit Episode");
			map.put("tvSeries", tvSeriesModel);
			return "tvSeries";
		} else {
			com.faisal.watchindia.dto.TvSeries tvSeriesDTO = new com.faisal.watchindia.dto.TvSeries();
			BeanUtils.copyProperties(tvSeriesModel, tvSeriesDTO);
			tvSeriesService.edit(tvSeriesDTO);
			return "redirect:/index";
		}
	}

	/* Delete */

	@RequestMapping(value = { "/tvSeries" }, method = RequestMethod.GET, params = "delete")
	public String setupTvSeriesDeleteForm(@RequestParam("id") int id, Map<String, Object> map) {
		TvSeries tvSeries = tvSeriesService.getTvSeries(id);
		map.put("message", "Delete Episode?");
		map.put("tvSeries", tvSeries);
		return "tvSeries";
	}

	@RequestMapping(value = { "/tvSeries" }, method = RequestMethod.POST, params = "delete")
	public String tvSeriesDeletePost(@RequestParam("id") int id) {
		tvSeriesService.delete(id);
		return "redirect:/index";
	}

}
