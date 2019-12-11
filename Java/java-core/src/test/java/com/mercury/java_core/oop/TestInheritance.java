package com.mercury.java_core.oop;

public class TestInheritance {
	// Understand the static 
	
	public static void main(String[] args) {
		Child c = new Child();
		
		System.out.println(c.x);
		c.print();
		c.x = 5;
		
		Child c2 = new Child();
		System.out.println(c2.x);
		System.out.println(c.x);
		
		System.out.println(c.y);
		c.y = 10;
		System.out.println(c2.y);
		
	}

}
