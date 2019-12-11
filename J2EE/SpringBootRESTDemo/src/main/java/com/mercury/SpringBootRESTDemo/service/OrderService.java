package com.mercury.SpringBootRESTDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRESTDemo.bean.Order;
import com.mercury.SpringBootRESTDemo.dao.OrderDao;

@Service
public class OrderService {
	@Autowired
	OrderDao orderDao;
	
	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}
}
