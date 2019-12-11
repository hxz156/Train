package com.mercury.java_core.thread;

public class TestThread {

	public static void main(String[] args) {
		// main 方法会对应一个 main thread
		// 任何 java 启动，又会有一个 garbage collection thread
		System.out.println("Current Thread: " + Thread.currentThread().getName());

		MyThread1 t1 = new MyThread1(); // create a new thread
		t1.setName("my own thread");
		t1.start(); // start a thread, then thread's run method will be executed. It is new thread
		
//		t1.run(); 
		// use run(), Java will not start a new Thread, the run method is executing
		// in the current main thread
		// What is the difference between invoking start() and run()? (key)
		
		//======================================================================================
		// Another way to create thread different
		// Define a runnable object, then put it in new Thread()
		// This one is better than above one, because MyThread1.java extends, which can only
		// extend one class
		Runnable r1 = new MyRunnable1();
		Thread t2 = new Thread(r1);
		t2.start();
		
		// Because it is Functional interface, we can easily create thread using lambda function
		// Lambda function to Override run()
		Runnable r2 = () -> {
			System.out.println("abc");
		};
		new Thread(r2).start();
	}
}










