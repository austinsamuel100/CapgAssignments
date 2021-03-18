package com.app.model;

public class Customer {
	private int id;
	private String name;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String address;
	//constructor of Customer class
	public Customer() {
	}
	//constructor of Customer class
	public Customer(int id, String username, String password, String name, String email, String phone, String address) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	//constructor of Customer class
	public Customer(String username, String password, String name, String email, String phone, String address) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
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
	public String getUsername() {
		return username;
	}
	//setter
	public void setUsername(String username) {
		this.username = username;
	}
	//getter
	public String getPassword() {
		return password;
	}
	//setter
	public void setPassword(String password) {
		this.password = password;
	}
	//getter
	public String getEmail() {
		return email;
	}
	//setter
	public void setEmail(String email) {
		this.email = email;
	}
	//getter
	public String getPhone() {
		return phone;
	}
	//setter
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//getter
	public String getAddress() {
		return address;
	}
	//setter
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", name = " + name + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
}
