package com.mercury.SpringBootRESTDemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRESTDemo.bean.User;
import com.mercury.SpringBootRESTDemo.service.UserService;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String hello() {
		List<User> users = userService.getAllUsers();
		return "Hello!";
	}
	
	// http://localhost:8080/hello/primes/1000
	// 表示方法需要缓存：
	@GetMapping("/primes/{num}")
	@Cacheable("primes")
	public int getPrimes(@PathVariable("num") int num) {
		return getAllPrimeNumbersCountUnder(num);
	}
	
	// Spring Cache 使用原因：
	// 同一个值，每次返回同一个result，所以可以存起来。
	Map<Integer, Integer> results;
	
	
	public int getAllPrimeNumbersCountUnder(int num) {
		try {
			Thread.sleep(num * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return (int)(Math.random() * 1000);
	}
}






