package com.faisal.watchindia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movies {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="year_of_release")
	Integer yearOfRelease;

	@Column(name="description")
	String description;
	
	@Column(name="genre")
	String genre;
	
	public Movies(){}

	public Movies(int id, String name, Integer yearOfRelease, String description, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.yearOfRelease = yearOfRelease;
		this.description = description;
		this.genre = genre;
	}

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
