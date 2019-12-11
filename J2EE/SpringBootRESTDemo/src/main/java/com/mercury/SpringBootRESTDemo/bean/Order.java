package com.mercury.SpringBootRESTDemo.bean;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="msi_order")
public class Order {
	@Id
	private long id;
	
//	private Date purchase_date;
// 	LocalDate > Date
	@Column
	private LocalDate purchase_date;
	
	// many orders to one user: many to one
	// map 两个 table，从两个 table 里面找关系。
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;
	
	// 本来 Order 里面没有 purchase.
	// We want to get purchases when we have the order, so create Set<Purchase>.
	// Join relation has already been declared in purchase, so no need to
	// declare JoinColumnName(...), just add (mappedBy="order").
	// (mappedBy="order") :去 purchase 下面定义的 order field 上面的映射关系。
	// "ManyToMany" 也可以这样去拿映射关系。
	@OneToMany(mappedBy="order")
	Set<Purchase> purchases;

	public Order() {
		super();
	}

	public Order(long id, LocalDate purchase_date, User user, Set<Purchase> purchases) {
		super();
		this.id = id;
		this.purchase_date = purchase_date;
		this.user = user;
		this.purchases = purchases;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(LocalDate purchase_date) {
		this.purchase_date = purchase_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", purchase_date=" + purchase_date + ", user=" + user + ", purchases=" + purchases
				+ "]";
	}
}










