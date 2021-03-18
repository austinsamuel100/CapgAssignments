package com.app.service;

public class AdminServiceImpl implements IAdminService {
	//admin credentials
	@Override
	public boolean login(String username, String password) {
		return username.equals("austin") && password.equals("austin");
	}

}
