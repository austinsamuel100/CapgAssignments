package com.app.controller;

import java.util.List;
import java.util.Scanner;

import com.app.model.Customer;
import com.app.model.Product;
import com.app.service.AdminServiceImpl;
import com.app.service.CustomerServiceImpl;
import com.app.service.IAdminService;
import com.app.service.ICustomerService;
import com.app.service.IProductService;
import com.app.service.ProductServiceImpl;
import com.app.util.DateUtil;
import com.app.util.InputUtil;
import com.app.util.LoginUtil;

public class AdminController {
	
	private static boolean loggedIn;
	private static IAdminService adminService = new AdminServiceImpl();
	private static IProductService productService = new ProductServiceImpl();
	private static ICustomerService customerService = new CustomerServiceImpl();
	
	public AdminController() {		
		if(!loggedIn) {
			String[] loginInfo = LoginUtil.getLoginInfo();
			if(adminService.login(loginInfo[0], loginInfo[1])) {
				loggedIn = true;
				System.out.println("Login successful!!");
			} else {
				System.out.println("Invalid username or password. Please try again.");
			}
		}
	}
	//admin operations
	public void operations() {
		if(loggedIn) {
			Scanner scanner = InputUtil.getScanner();
			boolean action = true;
			while (action) {
				System.out.println("---Welcome to Admin operations---");
				System.out.println("1. Manage products\n2. Manage customers\n3. Logout");

				System.out.println("enter your choice:");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					this.manageProducts();
					break;
				case 2:
					this.manageCustomers();
					break;
				case 3:
					action = false;
					loggedIn = false;
					System.out.println("Logged out");
					 break;
				default:
					System.out.println("Invalid choice!!");
					 break;
				}
			}
		}
		return;
	}
	//product operations of admin
	private void manageProducts() {
		Scanner scanner = InputUtil.getScanner();
		boolean action = true;
		while (action) {
			System.out.println("---Welcome to Admin operations - Manage Products---");
			System.out.println("1. Add product\n2. Remove product\n3. Update product\n4. View product\n5. View all products\n6. Go back");

			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					if(productService.addProduct(this.readProductInfo())) {
						System.out.println("Product added successfully!!");
					} else {
						System.out.println("Error while adding product. Please try again.");
					}
					 break;
				case 2:
					System.out.println("Enter product id: ");
					if(productService.removeProduct(InputUtil.getItemId())) {
						System.out.println("Product removed successfully!!");
					} else {
						System.out.println("Error while removing product. Please try again.");
					}
					 break;
				case 3:
					System.out.println("Enter product id: ");
					Product oldProduct = productService.getProduct(InputUtil.getItemId());
					if(oldProduct != null) {
						Product updatedProduct = this.updateProductInfo(oldProduct.getId());
						if(productService.updateProduct(updatedProduct)) {
							System.out.println("Product updated successfully!!");
						} else {
							System.out.println("Error while updating product. Please try again.");
						}	
					}
					 break;
				case 4:
					System.out.println("Enter product id: ");
					Product product = productService.getProduct(InputUtil.getItemId());
					if(product != null ) {
						System.out.println(product.toString());
					} else {
						System.out.println("Product not found");
					}
					 break;
				case 5:
					List<Product> products = productService.getAllProducts();
					if(products.size() == 0) {
						System.out.println("No product found");
					} else {
						for(Product p: products) {
							System.out.println(p.toString());
						}	
					}
				case 6:
					action = false;
					loggedIn = false;
					 break;
				 default:
					 System.out.println("Invalid choice!!");
			}
		}
	}
	//customer operations of admin
	private void manageCustomers() {
		Scanner scanner = InputUtil.getScanner();
		boolean action = true;
		while (action) {
			System.out.println("---Welcome to Admin operations - Manage Customers---");
			System.out.println("1. View customer\n2. View all orders\n3. Go back");

			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					List<Customer> customerList = customerService.getAllCustomers();
					if(customerList.size() > 0) {
						for(Customer customer: customerList) {
							System.out.println(customer.toString());
						}
					} else {
						System.out.println("No customer found");
					}
					 break;
				case 2:
					List<Long> orderList = customerService.getAllOrders();
					if(orderList.size() > 0) {
						System.out.print("[");
						for(Long orderId: orderList) {
							System.out.print(orderId + ", ");
						}
						System.out.println("]");
					} else {
						System.out.println("No orders has been placed yet!!");
					}
					 break;
				case 3:
					action = false;
					loggedIn = false;
					 break;
				 default:
					 System.out.println("Invalid choice!!");
			}
		}
	}
	//read info of product method
	private Product readProductInfo() {
		Scanner scanner = InputUtil.getScanner();
		Product product = new Product();
		System.out.println("Enter product name, price, qty, manufactured date (format: dd/MM/yyyy), expiry date (format: dd/MM/yyyy): ");
		product.setName(scanner.next());
		product.setPrice(scanner.nextDouble());
		product.setQty(scanner.nextInt());
		product.setManufacturedDate(DateUtil.stringToDate(scanner.next()));
		product.setExpiryDate(DateUtil.stringToDate(scanner.next()));
		
		return product;
	}
	//update details of product method
	private Product updateProductInfo(int productId) {
		Scanner scanner = InputUtil.getScanner();
		Product product = new Product();
		product.setId(productId);
		System.out.println("Enter product name, price, qty, manufactured date (format: dd/MM/yyyy), expiry date (format: dd/MM/yyyy): ");
		product.setName(scanner.next());
		product.setPrice(scanner.nextDouble());
		product.setQty(scanner.nextInt());
		product.setManufacturedDate(DateUtil.stringToDate(scanner.next()));
		product.setExpiryDate(DateUtil.stringToDate(scanner.next()));
		
		return product;
	}

}
