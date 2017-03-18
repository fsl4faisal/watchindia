package com.faisal.watchindia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOVIES")
public class Movies {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	int id;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="YEAR_OF_RELEASE")
	int yearOfRelease;
	
	@Column(name="DESCRIPTION")
	String description;
	
	@Column(name="GENRE")
	String genre;
	
	public Movies(){}

	public Movies(int id, String name, int yearOfRelease, String description, String genre) {
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

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
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
