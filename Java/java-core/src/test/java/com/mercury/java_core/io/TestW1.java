package com.mercury.java_core.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestW1 {

	public static void main(String[] args) {
		// 11111111 11111111 11111111 11111111 = -1
									// 11111111 = 255
		
		// 							  10000111 = 1234567
									// 10000111 = 135 (binary)
		// write is not right, then read would not be the right.
		
		int[] nums = {-1, 2, 3, 4, 1234567};
		
		// write data to a file
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("data/test1.txt");
			for(int n : nums){
				fos.write(n);	// only write 1 byte, which is last byte of Integer
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
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




