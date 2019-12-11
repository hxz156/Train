package com.mercury.java_core.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestR3 {
	public static void main(String[] args) {
		try (
				// Because we need to close the following afterward
				// Write this after try(), Java auto write finally() for you
				FileInputStream fis = new FileInputStream("data/test3.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			Data data = (Data) ois.readObject();
			System.out.println(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}










