package com.mercury.jdbc_demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mercury.jdbc_demo.bean.Sample;
import com.mercury.jdbc_demo.util.JdbcUtil;

public class TestStatement {
	// use statement to operate DB.
	public static void main(String[] args) {
		try (
			// AutoCloseable:
			Connection conn = JdbcUtil.getConnection();
		){
			// 插入数据
//			Sample s1 = new Sample("david", 25);
//			String sql1 = "INSERT INTO sample(name, age) VALUES('" + s1.getName() + "', " + s1.getAge() + ")";
////			String sql1 = "INSERT INTO sample(name, age)"
////					+ "VALUES('" + s1.getName() +"', " +s1.getAge() +  ")";
//			
//			Statement st1 = conn.createStatement(); // execute sql statement
//			st1.executeQuery(sql1);
			
			// how to read data from DB?
			String sql2 = "SELECT * FROM sample";
			Statement st2 = conn.createStatement();
			// ResultSet is a special object receive the DB.
			ResultSet rs = st2.executeQuery(sql2);
			
			while(rs.next()) {
				//rs.getString("name"); 拿到 column 为 name 的这一行的数据
				Sample s = new Sample(rs.getString("name"), rs.getInt("age"));
				System.out.println(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}







