package com.mercury.java_core.oop;

public class Key implements Cloneable{

	private int code;

	public Key(int code) {
		super();
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Key [code=" + code + "]";
	}
	
	@Override
	public Key clone() throws CloneNotSupportedException{
		return (Key)super.clone();
	}
}








