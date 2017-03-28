package com.faisal.watchindia.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.faisal.watchindia.constants.UserType;

@Component
public class Users {

	int id;

	@NotEmpty(message = "username can not be empty")
	private String username;

	private String password;

	@NotNull(message="please enter enabled")
	private Boolean enabled;

	@NotEmpty(message="please enter first name")
	private String firstName;

	@NotEmpty(message="please enter last name")
	private String lastName;

	@NotEmpty(message="please enter email id")
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	private String emailId;
	
	@NotNull(message="Role can not be left Empty")
	private UserType role;

	public Users() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
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

	public UserType getRole() {
		return role;
	}

	public void setRole(UserType role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", role=" + role
				+ "]";
	}

	
}
