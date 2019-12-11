package com.mercury.java_core.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.mercury.java_core.oop.User;

public class Data implements Serializable {
	// implements Serializable: allow people to write this Object into File
	
	
	/**
	 * 
	 */
	// serialVerionUID: What if we changed the class after write it into File?
	// then we need this. If we just change the number, Java still changed the ID
	// so, if we keep ourown ID. Then we will not have exception.
	private static final long serialVersionUID = 1L;
	
	int i = 123;
	boolean b = true;
	
	// transient: This field would not be written into File
	transient double pi = 3.1415926;
	
	// static: static fields will not be written into a file/stream, 
	// but it is in the method area
	static int j = 999;
	
	Account account;
	User user;	// Will have exception when read/write put it into read/write method
				// because it does not implement Serializable interface
	
	@Override
	public String toString() {
		return "Data [i=" + i + ", b=" + b + ", pi=" + pi + ", j=" + j + "]";
	}
	
	// This is used to customize read and write if you implements Serializable
	// and it should be private (>>8 是为了解密)
	private void readObject(ObjectInputStream in) throws IOException{
		i = in.readInt() >> 8;
		b = in.readBoolean();
	}
	
	// This is used to customize read and write if you implements Serializable
	// and it should be private (<<8 是为了加密)
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeInt(i << 8);
		out.writeBoolean(b);
	}
}



