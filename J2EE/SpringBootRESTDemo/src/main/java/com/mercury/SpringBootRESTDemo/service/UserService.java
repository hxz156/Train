package com.mercury.SpringBootRESTDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRESTDemo.bean.User;
import com.mercury.SpringBootRESTDemo.dao.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	public void register(User user) {
		// hashing password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}
}
