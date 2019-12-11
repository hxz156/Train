package com.mercury.java_core.oop;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClonable {

	@Test
	public void test() throws CloneNotSupportedException{
						// we must do "throws CloneNotSupportedException"
		// Object
		User user = new User("Bob", 21);
		User user1 = user.clone();	// For User.class, we have to write
									// Clone() method
		
		assertEquals(user.getName(), user1.getName()); // use .equals()
		assertEquals(user.getAge(), user1.getAge());
		assertNotSame(user, user1);		// use ==
	}

	@Test
	public void testWithKey() throws CloneNotSupportedException{
		Key key = new Key(12);
		User user = new User("bob", 21, key);
		User user1 = user.clone();
		assertNotSame(user.getKey(), user1.getKey());
	}
}










