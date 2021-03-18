package com.app.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.app.model.Customer;
import com.app.model.Product;

public class CustomerServiceTest {

	private static ICustomerService customerService = new CustomerServiceImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        System.out.println("before class");  
	}


	@Before
	public void setUp() throws Exception {
        System.out.println("before method test");  
	}

	
	@Test
	public void testCustomerRegister() {
		System.out.println("Register user");
		Customer customerRegister = new Customer("austin", "pin", "austin samuel", "as@gmail.com", "123456", "noida");
		assertTrue(customerService.register(customerRegister));
		
	}
	
	@Test
	public void testCustomerLogin() {
		Customer customerLogin = new Customer("rahul", "pin", "rahul sharma", "rs@gmail.com", "123456", "Delhi");
		System.out.println("Login method");
		customerService.register(customerLogin);
		assertEquals(customerLogin, customerService.login("rahul", "pin"));
	}
	
	@Test
	public void testCustomerLoginWrongUsername() {
		Customer customerLogin = new Customer("rahul", "pin", "rahul sharma", "rs@gmail.com", "123456", "Delhi");
		System.out.println("Wrong Username test");
		customerService.register(customerLogin);
		assertEquals(customerLogin, customerService.login("mohit", "pin"));
		fail("wrong username");
	}
	
	@Test
	public void testCustomerLoginWrongPassword() {
		Customer customerLogin = new Customer("rahul", "pin", "rahul sharma", "rs@gmail.com", "123456", "Delhi");
		System.out.println("Wrong password test");
		customerService.register(customerLogin);
		assertEquals(customerLogin, customerService.login("rahul", "pass"));
		fail("wrong password");
	}
	
	
	
	@Test
	public void testViewCart() {
		Customer customerLogin = new Customer("rahul", "pin", "rahul sharma", "rs@gmail.com", "123456", "Delhi");
		customerService.register(customerLogin);
		customerService.login("rahul", "pin");
		Product product = new Product(1200,"Iphone", 90000.0, 1, new Date(), new Date());
		List<Product> list = new ArrayList<Product>();
		list.add(product);
		customerService.addToCart("rahul", product);
		System.out.println("View cart");
		assertEquals(list, customerService.viewCart("rahul"));
	}
	
	@Test
	public void wrongParameter() {
		Customer customerRegister = new Customer("austin", "pin", "austin samuel", "as@gmail.com", "123456ab", "noida");	
		assertEquals(false,customerService.register(customerRegister));
		fail("Wrong parameter");
		}
		
	@Test
	public void lessParameter() throws Exception {
		Customer customerRegister = new Customer("austin", "pin", "", "as@gmail.com", "123456", "noida");	
		assertEquals(true,customerService.register(customerRegister));
		fail("it is having less paramter");
		}
	
	@After
	public void tearDown() throws Exception {
        System.out.println("after method test");  
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
        System.out.println("after class");  
	}

}