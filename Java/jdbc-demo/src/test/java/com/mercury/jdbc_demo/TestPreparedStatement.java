package com.mercury.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mercury.jdbc_demo.bean.Sample;
import com.mercury.jdbc_demo.util.JdbcUtil;

public class TestPreparedStatement {

	public static void main(String[] args) {
		// 隐患： SQL injection attack
		try (Connection conn = JdbcUtil.getConnection();) {
//            String name = "bob";
//            
//            // 下面的语句可以选出所有的用户信息。因为 or 永远为 true.
////            String name = "bob' or '1' = '1";
//            String sql2 = "SELECT * FROM sample WHERE name = '" + name + "'";
//            Statement st2 = conn.createStatement();
//            ResultSet rs = st2.executeQuery(sql2);
//            while (rs.next()) {
//                Sample s = new Sample(rs.getString("name"), rs.getInt("age"));
//                System.out.println(s);
//            }
// ==========================================================================
            // parameterized SQL query
			// 防止入侵
            String sql3 = "SELECT * FROM sample where name = ?";
            PreparedStatement ps = conn.prepareStatement(sql3);
            
            // 1 的意思就是 第一个 参数:
            ps.setString(1, "bob");
            ResultSet rs1 = ps.executeQuery();
            while (rs1.next()) {
              Sample s = new Sample(rs1.getString("name"), rs1.getInt("age"));
              System.out.println(s);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

}











