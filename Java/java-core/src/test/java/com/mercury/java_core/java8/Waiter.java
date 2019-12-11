package com.mercury.java_core.java8;

public class Waiter {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Waiter(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Waiter [name=" + name + "]";
	}
}




