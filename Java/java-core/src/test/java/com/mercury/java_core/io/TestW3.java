package com.mercury.java_core.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestW3 {

	public static void main(String[] args) {
		Data data = new Data();
		try (
				FileOutputStream fos = new FileOutputStream("data/test3.txt");
				// how to use buffer: (buffer 就是包装一下，提高速度)
				// 数据多的时候，效果很明显
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
		) {
			oos.writeObject(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
