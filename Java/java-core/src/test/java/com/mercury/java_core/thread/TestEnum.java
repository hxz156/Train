package com.mercury.java_core.thread;

public class TestEnum {

	public static void main(String[] args) {
		
		// 创建的时候，只有四个选择。 enum 创建的时候就只能从制定
		// 的几个里面选择。
		Direction d = Direction.SOUTH;
		System.out.println(d);
		
		System.out.println(d.code);
	}

}








