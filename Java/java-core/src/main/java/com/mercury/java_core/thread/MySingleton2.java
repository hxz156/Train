package com.mercury.java_core.thread;

// lazy singleton (记住 double check 就行)
public class MySingleton2 {
	
	private static MySingleton2 instance;
	
	// 先把 constructor 创成 private，外部分就无法创建 Object
	private MySingleton2(){}
	
	// 在使用的时候再去创建 instance
	public static MySingleton2 getInstance(){
		if(instance == null){
			instance = new MySingleton2();
		}
		return instance;
		
	}
	
}







