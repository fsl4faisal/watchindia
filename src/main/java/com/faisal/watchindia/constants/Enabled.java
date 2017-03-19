package com.faisal.watchindia.constants;

public enum Enabled {
	TRUE("TRUE", 1), 
	FALSE("FALSE",0);
	
	String name;
	Integer value;

	private Enabled(String name, Integer value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
