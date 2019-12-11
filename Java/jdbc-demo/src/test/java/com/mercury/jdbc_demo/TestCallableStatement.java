package com.mercury.jdbc_demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.mercury.jdbc_demo.util.JdbcUtil;

public class TestCallableStatement {

	public static void main(String[] args) {
		// 不需要记住下面代码，需要理解在干什么。
		try( 
			Connection conn = JdbcUtil.getConnection();
		){
			// how to invoke a function?
			// ?= : 表示有一个返回的结果
			// (?): 表示需要接受一个参数
			String sql1 = "{?=call GET_SAMPLE_COUNT_BY_MIN_AGE(?)}";
			CallableStatement cs1 = conn.prepareCall(sql1);
			
			// 2： 表示第二个参数.
			cs1.setInt(2, 23);
			
			// 指定返回值是一个 Integer: (第一个参数)
			cs1.registerOutParameter(1, Types.INTEGER);
			cs1.execute();
			System.out.println(cs1.getInt(1));
			
//===========================================================================
			// ADD_SAMPLE 不是 function 是 Store Procedure
			// how to invoke a Store Procedure
			
			String sql2 = "{call ADD_SAMPLE(?, ?, ?, ?)}";
            CallableStatement cs2 = conn.prepareCall(sql2);
            cs2.setString(1, "Terry");
            cs2.setInt(2, 99);
            cs2.registerOutParameter(3, Types.INTEGER);
            cs2.registerOutParameter(4, Types.INTEGER);
            cs2.execute();
            System.out.println(cs2.getInt(3));
            System.out.println(cs2.getInt(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}




