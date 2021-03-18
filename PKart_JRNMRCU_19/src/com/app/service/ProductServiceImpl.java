package com.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.dao.*;
import com.app.model.Product;

public class ProductServiceImpl implements IProductService {
	
	private static IProductDao productDao = new ProductDaoImpl();

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(product) != null;
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return productDao.getProduct(productId);
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product) != null;
	}

	@Override
	public boolean removeProduct(int productId) {
		// TODO Auto-generated method stub
		return productDao.removeProduct(productId) != null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	@Override
	public List<Product> getNonExpiredProducts() {
		List<Product> products = productDao.getAllProducts();
		List<Product> nonExpiredProducts = new ArrayList<Product>();
		
		for(Product product: products) {
			if(product.getExpiryDate().after(new Date())) {
				nonExpiredProducts.add(product);
			}
		}
		
		return nonExpiredProducts;
	}

}
