package com.faisal.watchindia.constants;

public enum UserType {
	FREEUSER("Free User","FREEUSER"),
	PREMIUMUSER("Premium User","PREMIUMUSER");
	
	private String value,name;
	
	private UserType(String name,String value){
		this.name=name;
		this.value=value;
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
