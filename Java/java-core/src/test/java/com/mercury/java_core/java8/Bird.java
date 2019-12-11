package com.mercury.java_core.java8;

public class Bird implements Flyable, Eatable {

	@Override
	public void fly() {
		System.out.println("Bird.class, fly() method");

	}
	
	// 因为 implements Flyable, Eatable，并且两个 interface 都有 test1（）
	// 所以必须 override test1（） ，否则 java 会 confused
	// 如果只有一个 interface，就不需要 Override 也能用
	@Override
	public void test1() {
		System.out.println("Bird.class, test1");
	}
	
}



