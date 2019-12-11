package com.mercury.java_core.thread;
public class TestMyIntList {

	public static void main(String[] args) throws InterruptedException {
		MyIntList mil1 = new MyIntList();
		MyIntList mil2 = new MyIntList();
//		mil1.add(1);
//		mil1.add(2);
		
		// Using two thread to add number
		Thread t1 = new Thread(() ->{
			MyIntList.test3();
//			mil1.add(1);
//			mil1.add(2);
		} );
		
		Thread t2 = new Thread(() ->{
			MyIntList.test3();
//			mil2.add(3);
//			mil2.add(4);
		} );
		
		t1.start();
		t2.start();
		
		// make main thread to sleep for at least 500 ms
		// codes after this will be executed later
		// 确保 sysout 能打出1，2； 但是这个方法不够好
//		Thread.sleep(500);
		
		// main thread will wait for thread1 and thread2 finished then continue
		t1.join();
		t2.join();
		
		// 这个可能会在 tread1 和 thread2 之前执行。因为 t1，t2 没有得到 time slice
//		System.out.println(mil1);
		
		System.out.println(MyIntList.ai.get());
		
	}

}

























