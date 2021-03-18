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

public class ProductServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        System.out.println("before class");  
	}


	@Before
	public void setUp() throws Exception {
        System.out.println("before method test");  
	}

	
	private static IProductService productService = new ProductServiceImpl();
	
	
	
	@Test
	public void testAddProduct() {
		Product product = new Product(1200,"Brush", 89.9, 2, new Date(), new Date());
		System.out.println("Add product to cart");
		assertEquals(true,productService.addProduct(product));
	}
	
	@Test
	public void testUpdateProduct() {
		Product product = new Product(1200,"Brush", 89.9, 2, new Date(), new Date());
		productService.addProduct(product);
		Product product1 = new Product(1200,"Bat", 89.9, 2, new Date(), new Date());
		System.out.println("Update product");
		assertEquals(true,productService.updateProduct(product));
	}
	
	
	@Test
	public void testNegativePrice() {
		Product product = new Product(1200,"Brush", -89.9, 2, new Date(), new Date());	
		assertEquals(true,productService.addProduct(product));
		fail("Negative price entered");
		}
		
	@Test
	public void testNoName() throws Exception {
		Product product = new Product(1200,"", 89.9, 2, new Date(), new Date());	
		assertEquals(false,productService.addProduct(product));
		fail("No Name of Product");
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