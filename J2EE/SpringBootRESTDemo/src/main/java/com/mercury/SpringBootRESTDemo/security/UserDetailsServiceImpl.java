package com.mercury.SpringBootRESTDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRESTDemo.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	// UserService 是我们自己使用，UserDetailsServiceImpl 是给 Spring Security 用。
	// 可以通过用户名加载一个用户。
	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// findByUsername() 是自己按照特定一个格式写的。
		return userDao.findByUsername(username);
	}

}
