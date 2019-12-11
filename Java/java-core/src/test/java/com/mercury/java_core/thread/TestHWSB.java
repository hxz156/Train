package com.mercury.java_core.thread;
import java.util.concurrent.atomic.AtomicInteger;

public class TestHWSB {
	// 用 atomic 和 synchronized block 或者 Data 里面 synchronized getX() and setX()  
	// 3 个做,想要： 11，12

	static class Data {
		 int x = 10;
		 int getX(){
			return x;
		}
		 void increaseOne(){
			x++;
		}
	}

	public static void main(String[] args) {
		Data data = new Data();

		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 在 main method 里面用
			synchronized(data){
				data.increaseOne();
				System.out.println(data.getX() + " in t1");
			}
		});
		Thread t2 = new Thread(() -> {
			synchronized(data){
				data.increaseOne();
				System.out.println(data.getX() + " in t2");
			}
		});
		t1.start();
		t2.start();
	}

}














