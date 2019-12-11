package com.mercury.java_web_demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mercury.java_web_demo.bean.Sample;
import com.mercury.java_web_demo.util.JdbcUtil;

public class SampleDao {

	// define methods to CRUD sample table.
	
	public List<Sample> getSamples() {
		List<Sample> list = new ArrayList<>();
        try (
            Connection conn = JdbcUtil.getConnection();
        ) {
            String sql = "SELECT * FROM sample";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sample s = new Sample(rs.getString("name"), rs.getInt("age"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
	}
	
	public void updateSample(Sample sample) {
		
	}
	
	public boolean addSample(Sample sample) {
		try (Connection conn = JdbcUtil.getConnection();) {
            String sql = "INSERT INTO sample VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sample.getName());
            ps.setInt(2, sample.getAge());
            ps.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
	}
	
	public boolean deleteSample(String name) {
		try (Connection conn = JdbcUtil.getConnection();) {
            String sql = "DELETE FROM sample WHERE NAME = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
	}
	
}
















