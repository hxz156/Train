package com.mercury.java_core.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestHW {
	// 用 atomic 和 synchronized block 或者 Data 里面 synchronized getX() and setX()  
	// 3 个做,想要： 11，12

	static class Data {
		static AtomicInteger ai = new AtomicInteger(10);	
	}

	public static void main(String[] args) {
		Data data = new Data();

		Thread t1 = new Thread(() -> {
//			data.ai.getAndIncrement();
//			System.out.println(Data.ai.getAndIncrement() + " in t1");
		});
		Thread t2 = new Thread(() -> {
//			data.ai.getAndIncrement();
			System.out.println(Data.ai.getAndIncrement() + " in t2");
		});
		t1.start();
		t2.start();
	}

}
