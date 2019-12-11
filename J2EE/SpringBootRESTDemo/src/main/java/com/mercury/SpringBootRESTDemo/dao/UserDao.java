package com.mercury.SpringBootRESTDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRESTDemo.bean.User;

public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
