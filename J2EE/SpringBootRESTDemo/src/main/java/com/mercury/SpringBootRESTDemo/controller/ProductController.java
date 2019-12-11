package com.mercury.SpringBootRESTDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRESTDemo.bean.Product;
import com.mercury.SpringBootRESTDemo.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getProducts() {
		return productService.getAllproducts();
	}
	
}
