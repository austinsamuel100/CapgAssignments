package com.app.model;

public class Admin {
	private String username;
	private String password;
	//constructor to initialize username and passsword
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
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
}
