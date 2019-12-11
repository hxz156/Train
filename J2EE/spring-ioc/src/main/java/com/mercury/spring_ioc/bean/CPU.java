package com.mercury.spring_ioc.bean;

// java bean class, encapsulation
public class CPU {
	private String brand;
	private String model;
	public CPU() {
		super();
	}
	public CPU(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "CPU [brand=" + brand + ", model=" + model + "]";
	}
	
	
}
