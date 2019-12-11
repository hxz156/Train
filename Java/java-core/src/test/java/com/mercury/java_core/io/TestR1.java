package com.mercury.java_core.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestR1 {

	public static void main(String[] args) {
		// after try, in the brackets, it should be auto-closable.
		// then you could avoid write finally block to close
		try (FileInputStream fis = new FileInputStream("data/test1.txt");) {

			int data = fis.read(); // read the file byte by byte
									// return -1 if reach the end
			while (data != -1) {
				System.out.println(data);
				data = fis.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
