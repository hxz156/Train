package com.mercury.SpringBootRESTDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="msi_order_product")
public class Purchase {
	@Id
	private long id;
	@Column
	private long qty;
	
	// one purchase include one product
	// one product could exist in many purchases.
	@ManyToOne
	@JoinColumn(name="product_id", referencedColumnName="id")
	private Product product;

	@ManyToOne
	@JoinColumn(name="order_id", referencedColumnName="id")
	@JsonIgnore // 解决死循环，order -> purchase -> order -> ...
	private Order order;

	public Purchase() {
		super();
	}

	public Purchase(long id, long qty, Product product, Order order) {
		super();
		this.id = id;
		this.qty = qty;
		this.product = product;
		this.order = order;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", qty=" + qty + ", product=" + product + ", order=" + order + "]";
	}
}








