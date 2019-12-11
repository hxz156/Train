package com.mercury.java_core.oop;

public class SuperUser extends User {

	@Override
	public SuperUser clone() throws CloneNotSupportedException {
		
		throw new CloneNotSupportedException("We do not allow to clone super"
				+ "User");
	}
	@Override
	public String toString() {
		return "SuperUser [getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}
	
}






