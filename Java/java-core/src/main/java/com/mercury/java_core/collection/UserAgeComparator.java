package com.mercury.java_core.collection;

import java.util.Comparator;

import com.mercury.java_core.oop.User;

// define comparing logic for User
// younger user will come first
public class UserAgeComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		
		return o1.getAge() - o2.getAge();
		
	}

}



