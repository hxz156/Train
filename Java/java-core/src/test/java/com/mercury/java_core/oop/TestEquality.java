package com.mercury.java_core.oop;

import java.util.HashSet;
import java.util.Set;

public class TestEquality {

	public static void main(String[] args) {
		// == vs equals()
		
		User user1 = new User("Bob", 21);
		User user2 = new User("Bob", 21);
		System.out.println(user1 == user2);
		
		// Default Object.class, the .equals using ==
		System.out.println(user1.equals(user2));
		
		// Set -> using .equals to compare objects
		// user1.hashCode() == user2.hashCode() && user1.equals(user2)
		// So we have to Override both hashCode() and equals()
		Set<User> set = new HashSet<User>();
		set.add(user1);
		set.add(user2);
		System.out.println(set.size());
	}

}









