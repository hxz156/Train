package com.mercury.java_core.oop;

public class TestCasting {

	public static void main(String[] args) {
		
		Child c = new Child();
		Parent p = c; // up-casting
		
		Parent p1 = new Parent();
//		Child c1 = p1; // down-casting
//		Child c1 = (Child) p1;	// down-casting
		
		// code against super class/interface
		// Reference type - actual type
		Parent p2 = new Child();
		
		Child p3 = new Child();
		
		p2 = new Child1();	// because Child1 is subclass of Parent
	}
}
