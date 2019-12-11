package com.mercury.java_core.thread;

// double checking singleton (key!!)
public class MySingleton3 {

	private static MySingleton3 instance;	// 因为使用的 method 是static
											// 所以这里必须是 static 

	// 先把 constructor 创成 private，外部分就无法创建 Object
	private MySingleton3() {
	}

	// 在使用的时候再去创建 instance
	public static MySingleton3 getInstance() {
		// check 1: 不需要每一次都拿锁，只在 instance 是 null 的时候拿
		// check 2: 只需要保护这一块，因为 return 的时候不需要保护，可以多个 线程 return。 所以
		// 没有必要把整个 method synchronized
		if (instance == null) {
			synchronized (MySingleton3.class) { // 防止多个线程创建 instance
				if (instance == null) {
					instance = new MySingleton3();
				}
			}
		}
		return instance;
	}
}




