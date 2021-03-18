package com.app.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	private int id;
	private String name;
	private double price;
	private int qty;
	private Date manufacturedDate;
	private Date expiryDate;
	//constructor of Product class
	public Product() {
		
	}
	//constructor of Product class
	public Product(int id, String name, double price, int qty, Date manufacturedDate, Date expiryDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.manufacturedDate= manufacturedDate;
		this.expiryDate = expiryDate;
	}
	//getter
	public int getId() {
		return id;
	}
	//setter
	public void setId(int id) {
		this.id = id;
	}
	//getter
	public String getName() {
		return name;
	}
	//setter
	public void setName(String name) {
		this.name = name;
	}
	//getter
	public double getPrice() {
		return price;
	}
	//setter
	public void setPrice(double price) {
		this.price = price;
	}
	//getter
	public int getQty() {
		return qty;
	}
	//setter
	public void setQty(int qty) {
		this.qty = qty;
	}
	//getter
	public Date getManufacturedDate() {
		return manufacturedDate;
	}
	//setter
	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	//getter
	public Date getExpiryDate() {
		return expiryDate;
	}
	//setter
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");   
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + ", manufacturedDate=" + formatter.format(manufacturedDate) + ", expiryDate=" + formatter.format(expiryDate) + " ]";
	}
}
