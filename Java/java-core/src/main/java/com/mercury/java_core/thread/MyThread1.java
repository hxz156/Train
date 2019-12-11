package com.mercury.java_core.thread;

public class MyThread1 extends Thread {

	// Define your code your want to execute when your Thread is running
	@Override
	public void run() {
		System.out.println("My thread 1 - Current Thread: " + 
							Thread.currentThread().getName());
	}
}





