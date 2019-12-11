package com.mercury.java_core.io;

public class TestDoor {

	public static void main(String[] args) throws Exception {

		// We use try(), then Java will implicitly generate finally block to
		// close the Door contains close() method in Door class.
		try (Door door = new Door();) {
			door.open();
		}
		
	}

}
