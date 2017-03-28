package com.faisal.watchindia.constants;

public enum Enabled {
	TRUE("TRUE", true), 
	FALSE("FALSE",false);
	
	String name;
	Boolean value;

	private Enabled(String name, Boolean value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}
	
	
}
