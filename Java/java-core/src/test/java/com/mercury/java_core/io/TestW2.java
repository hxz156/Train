package com.mercury.java_core.io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestW2 {

	public static void main(String[] args) {
		// before Java 1.7, we need to do the following: 
		int i = -1;
		boolean b = true;
		double pi = 3.1415926;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("data/test2.txt");
			// Enhance of FileOut... 
			// (Will know what type is writing, like knowing exact bytes)
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(i);
			dos.writeBoolean(b);
			dos.writeDouble(pi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close connection/stream to release memory
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}









