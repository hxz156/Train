package com.mercury.java_core.thread;

public class TestVolatile {
	// 如果没有 volatile, java 取数据不会直接取内存，而是去之前的缓存 copy 里面取，所以取不到最新值。
	static volatile int num = 0; // primitive 一般会有缓存的拷贝
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() ->{
			while(true){
				if(num >= 5){
					break;
				}
			}
			System.out.println(num + " in t1");
		} );
		
		Thread t2 = new Thread(() ->{
			while(num < 10){
				num++;
				System.out.println(num + " in t2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} );
		
		t1.start();
		t2.start();
		
		
	}

}







