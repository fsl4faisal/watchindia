package com.faisal.watchindia.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;
@Component
public class Movies {

	int id;
	
	@NotEmpty(message="name can not be blank")
	String name;
	
	@NotNull(message="year of release can not be left blank")
	@Range(min=1980,max=2020,message="year should be between 1980 and 2020")
	Integer yearOfRelease;

	@NotEmpty(message="description can not be blank")
	String description;
	
	@NotEmpty(message="genre can not be blank")
	String genre;
	
	public Movies(){}

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

	public Integer getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(Integer yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
