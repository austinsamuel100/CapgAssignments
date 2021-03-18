package com.app.controller;

import java.util.Scanner;

import com.app.util.InputUtil;

public class MainController {

	public static void main(String[] args) {
		runApplication();
	}
	//main menu
	public static void runApplication() {
		Scanner scanner = InputUtil.getScanner();
		boolean action = true;
		
		while(action) {
			System.out.println("------WELCOME TO PKart-------");
			System.out.println("1. Admin\n2. Customer\n3. Exit");
			
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					AdminController adminController = new AdminController();
					adminController.operations();
					break;
				case 2:
					CustomerController customerController = new CustomerController();
					customerController.operations();
					break;
				case 3:
					action = false;
					break;
				default:
					System.out.println("Invalid choice!!");
			}
		}
	}
	
}
