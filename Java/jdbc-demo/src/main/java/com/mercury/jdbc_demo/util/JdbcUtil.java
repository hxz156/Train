package com.mercury.jdbc_demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// utility class to provide connection
// from java to DB.

public class JdbcUtil {
	// Connection is AutoCloseable.
	public static Connection getConnection() {
		// store both URL and the database name
		// 1521 is the port number, you can change this
		String URL = "jdbc:oracle:thin:@localhost:1521:XE";
		String USERNAME = "msi";
		String PASSWORD = "mercury";
		
		Connection conn = null;
		try {
			// use Driver manager to build connection
			// between Java and DB.
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
}






