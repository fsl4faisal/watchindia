package com.faisal.watchindia.constants;

public enum UserType {
	ROLE_FREE_USER("Free User", "ROLE_FREE_USER"), 
	ROLE_PREMIUM_USER("Premium User","ROLE_PREMIUM_USER"), 
	ROLE_ADMIN("Admin", "ROLE_ADMIN");

	private String value, name;

	private UserType(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
