package com.mercury.java_core.thread;

public class MyRunnable1 implements Runnable {
	// Runnable is a Functional interface 
	@Override
	public void run() {
		System.out.println("MyRunnable1 - Current Thread: " + 
				Thread.currentThread().getName());

	}

}
