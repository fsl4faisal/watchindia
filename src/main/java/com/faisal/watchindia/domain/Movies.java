package com.faisal.watchindia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="MOVIES")
public class Movies {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	int id;
	
	@Column(name="NAME")
	@NotEmpty
	String name;
	
	@Column(name="YEAR_OF_RELEASE")
	@NotNull
	Integer yearOfRelease;
	
	@Column(name="DESCRIPTION")
	@NotEmpty
	String description;
	
	@Column(name="GENRE")
	@NotEmpty
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
