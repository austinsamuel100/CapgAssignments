package com.app.dao;

import java.util.*;
import java.util.Map.Entry;

import com.app.model.Customer;
import com.app.model.Product;

public class CustomerDaoImpl implements ICustomerDao {
	
	private static Map<String, Customer> customers;
	private static Map<String, List<Product>> cart;
	private static Map<String, Map<Long, List<Product>>> orders;
	private static int origin = 1100;

	static {
		customers = new HashMap<String, Customer>();
		cart = new HashMap<String, List<Product>>();
		orders = new HashMap<String, Map<Long, List<Product>>>();
	}

	@Override
	public Customer createUser(Customer customer) {
		if(!customers.containsKey(customer.getUsername())) {
			int initialCustomersLength = customers.size();
			
//			Setting empty cart
			List<Product> cartItems = new ArrayList<Product>();
			cart.put(customer.getUsername(), cartItems);
			
//			Setting orders
			Map<Long, List<Product>> orderItems = new HashMap<>(); 
			orders.put(customer.getUsername(), orderItems);
			
			customer.setId(origin++);
			customers.put(customer.getUsername(), customer);
			
			return customers.size() > initialCustomersLength ? customer : null;
		}
		return null;
	}

	@Override
	public Customer getUser(String username) {
		return customers.get(username);
	}

	@Override
	public boolean addToCart(String username, Product product) {
		List<Product> products = cart.get(username);
		return products.add(product);
	}

	@Override
	public List<Product> viewCart(String username) {
		return cart.get(username);
	}

	@Override
	public boolean placeOrder(String username) {
		if(cart.get(username).size() > 0) {
			Long orderId = System.currentTimeMillis();
//			System.out.println(orderId +" " + orderId.getClass().getTypeName());
			orders.get(username).put(orderId, this.viewCart(username));
			cart.get(username).clear();
			return true;
		}
		return false;
	}
	
	@Override
	public List<Long> getAllOrders() {
		List<Long> orderList = new ArrayList<>();
		List<Long> keys;
		for (Entry<String, Map<Long, List<Product>>> entry : orders.entrySet())  {
			keys =  new ArrayList<Long>(entry.getValue().keySet());
			orderList.addAll(keys);
		}
		return orderList;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<Customer>(customers.values());
		return list;
	}

}
