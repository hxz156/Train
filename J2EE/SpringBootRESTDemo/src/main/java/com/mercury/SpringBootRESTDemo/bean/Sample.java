package com.mercury.SpringBootRESTDemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 表示和 db 里面的 table 连接上。
@Table(name="sample") // specify which table to connect with.
public class Sample {
	
	@Id // primary key
	private String name;
	
	@Column // default as: @Column(name="age")
	private int age;
	
	public Sample() {
		super();
	}
	public Sample(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Sample [name=" + name + ", age=" + age + "]";
	}
}
