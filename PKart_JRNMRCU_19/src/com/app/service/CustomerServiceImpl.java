package com.app.service;

import java.util.List;

import com.app.dao.*;
import com.app.model.Customer;
import com.app.model.Product;

public class CustomerServiceImpl implements ICustomerService {
	
	private static ICustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public boolean register(Customer customer) {
		return customerDao.createUser(customer) != null;
	}

	@Override
	public Customer login(String username, String password) {
		Customer customer= customerDao.getUser(username);
		if(customer != null && customer.getPassword().equals(password)) {
			return customer;
		}
		return null;
	}

	@Override
	public boolean addToCart(String username, Product product) {
		return customerDao.addToCart(username, product);
	}

	@Override
	public List<Product> viewCart(String username) {
		return customerDao.viewCart(username);
	}

	@Override
	public boolean placeOrder(String username) {
		return customerDao.placeOrder(username);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	@Override
	public List<Long> getAllOrders() {
		// TODO Auto-generated method stub
		return customerDao.getAllOrders();
	}

}
