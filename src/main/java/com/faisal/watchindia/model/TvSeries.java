
package com.faisal.watchindia.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
@Component
public class TvSeries {
	
	int id;
	
	@NotEmpty(message="please enter name")
	String name;
	
	@NotNull(message="season can't be left blank")
	Integer season;
	
	@NotNull(message="episode can't be left blank")
	Integer episode;
	
	@NotEmpty(message="please enter description")
	String description;
	
	public TvSeries(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
