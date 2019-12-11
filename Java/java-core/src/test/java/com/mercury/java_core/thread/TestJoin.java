package com.mercury.java_core.thread;

public class TestJoin {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("hello !");
		});
		t.start();
		
		// how to let main thread to wait for t to finish?
		// if not thread sleep for 2000ms, then the main will reach the end.
		try {
			t.join(); // before t not finished, main will not continue.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("end of main ");

	}
}












