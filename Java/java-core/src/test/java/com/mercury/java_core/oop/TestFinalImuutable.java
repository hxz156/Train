package com.mercury.java_core.oop;

public class TestFinalImuutable {

	public static void main(String[] args) {
		final int x = 1;
		
		final Child c = new Child();
		c.x = 2;
		System.out.println(c.x);
	}

}






