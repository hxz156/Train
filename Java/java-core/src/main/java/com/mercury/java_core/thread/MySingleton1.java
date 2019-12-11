package com.mercury.java_core.thread;

// eager mode singleton,只能创建一个 class。Reduce Object creation 这是最初始的 singleton.
// 但是这个在JMV程序已启动还没有用就创建了 object ， 浪费资源了。
// (记住 double check 就行)
public class MySingleton1 {
	
	// 静态类，在 MySingleton1。class 读取的时候就会自动加载。
	private static MySingleton1 instance  = new MySingleton1();
	
	private MySingleton1(){
		
	}
	
	public static MySingleton1 getInstance() {
		return instance;
	}
	
}







