package com.mercury.java_core.thread;

public class TestSingleton {

	public static void main(String[] args) {
		
		MySingleton1 ms1 = MySingleton1.getInstance();
		
		// 如果两个 instance 相等，就是 singleton
		MySingleton3 m3a = MySingleton3.getInstance();
		MySingleton3 m3b = MySingleton3.getInstance();
		System.out.println(m3a == m3b);
		
		// 用 enum 实现, enum 是在 java 内部自动用底层一个线程创建的，不存在多线程问题。
		MySingleton4 m4a = MySingleton4.INSTANCE;
		MySingleton4 m4b = MySingleton4.INSTANCE;
		System.out.println(m4a == m4b);

	}

}











