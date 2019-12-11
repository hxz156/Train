package com.mercury.java_web_demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	public static Connection getConnection() {
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String USERNAME = "msi";
        String PASSWORD = "mercury";
        String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
        
        Connection conn = null;
        
        try {
            
            Class.forName(DRIVER_CLASS);
            
            // build connection between Java and DB.
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return conn;
    }

}
