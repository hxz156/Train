package com.mercury.SpringBootRESTDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.SpringBootRESTDemo.bean.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.sample-app.finders.strategies
	// 按照一定的形式，定义一个自己的 query method.
	public List<Product> findByPriceGreaterThan(int price);
	
	// custom JPQL query
	@Query("select p from Product p where p.stock > :stock")
	public List<Product> iWantProductsWithCertainMinStocks(@Param("stock")int stock);
}
