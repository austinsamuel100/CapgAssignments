package com.app.service;

import java.util.List;

import com.app.model.Product;

public interface IProductService {
	boolean addProduct(Product product);
	
	Product getProduct(int productId);
	
	boolean updateProduct(Product product);
	
	boolean removeProduct(int productId);
	
	List<Product> getAllProducts();
	
	List<Product> getNonExpiredProducts();
}
