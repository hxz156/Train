package com.mercury.java_core.thread;

public enum Direction {
	// 逗号隔开， 分号结尾
	// 创建的时候，只能从四个里面选择。
	EAST(1), // 这一步相当于： EAST(1) = new Direction(1)
	SOUTH(2),
	WEST(3),
	NORTH(4);
	
	int code;	// 如果不想改 code，就 private 他, 再写一个 public int getCode()
	
	// enum 的 constructor 默认都是 private, 不写 private
	// 也是 private。 java 自动加上。
	private Direction(int code){
		this.code = code;
	}
	
	
}








