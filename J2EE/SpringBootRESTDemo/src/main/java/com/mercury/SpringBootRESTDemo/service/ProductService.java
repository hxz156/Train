package com.mercury.SpringBootRESTDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRESTDemo.bean.Product;
import com.mercury.SpringBootRESTDemo.dao.ProductDao;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	
	public List<Product> getAllproducts() {
		return productDao.findAll();
	}
}











