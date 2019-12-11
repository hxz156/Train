package com.mercury.java_core.io;

public class Door implements AutoCloseable {

	public Door(){
		System.out.println("Create door !");
	}
	
	public void open(){
		System.out.println("Open door !");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Close door !");

	}

}





