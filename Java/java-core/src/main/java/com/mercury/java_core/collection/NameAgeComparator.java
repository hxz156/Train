package com.mercury.java_core.collection;

import java.util.Comparator;

import com.mercury.java_core.oop.User;

public class NameAgeComparator implements Comparator<User> {

	@Override
	public int compare(User u1, User u2) {
		
		if(u1.getName().equals(u2)){
			return u1.getAge() - u2.getAge();
		}else{
			return u1.getName().compareTo(u2.getName());
		}
	}
	
}
