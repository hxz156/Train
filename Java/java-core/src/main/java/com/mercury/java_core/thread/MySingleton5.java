package com.mercury.java_core.thread;

// holder pattern. (lazy) (key!!)
public class MySingleton5 {

	private MySingleton5() {
	}

	// When java load outer Class, only static variables in outer class
	// will be initialized.
	// inner class and its fields will only be initialized when it
	// will be used.
	private static class Holder {
		// 这个创建是在 Holder class 初始的时候加载
		// java 的这个过程是一个独立线程步骤，不存在多线程问题。
		static final MySingleton5 INSTANCE = new MySingleton5();
	}

	public static MySingleton5 getInstance() {
		return Holder.INSTANCE;
	}
}








