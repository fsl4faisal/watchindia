package com.faisal.watchindia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.faisal.watchindia.constants.UserType;

@Entity
@Table(name="USERS")
public class Users {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="USERNAME")
	@NotEmpty(message="username can not be empty")
	String username;
	
	@Column(name="PASSWORD")
	@NotEmpty
	String password;
	
	@Column(name="ENABLED")
	@NotNull
	Integer enabled;
	
	@Column(name="FIRST_NAME")
	@NotEmpty
	String firstName;
	
	@Column(name="LAST_NAME")
	@NotEmpty
	String lastName;
	
	@Column(name="EMAIL_ID")
	@NotEmpty
	@Pattern(regexp=".+@.+\\.[a-z]+")
	String emailId;
	
	@Column(name="USER_TYPE")
	@NotNull
	@Enumerated(EnumType.STRING)
	UserType userType;
	
	public Users(){}


	public Users(int userId, String username, String password, Integer enabled, String firstName, String lastName,
			String emailId, UserType userType) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userType = userType;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Integer getEnabled() {
		return enabled;
	}



	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	
	
	
}
