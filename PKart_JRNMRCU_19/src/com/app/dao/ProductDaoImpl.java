package com.app.dao;

import java.util.*;

import com.app.model.Product;

public class ProductDaoImpl implements IProductDao {
	
	private static Map<Integer, Product> products;
	private static int origin = 1100;

	static {
		products = new HashMap<Integer, Product>();	
	}
	//add products method
	@Override
	public Product addProduct(Product product) {
		int initialProductsLength = products.size();
		
		product.setId(origin++);
		products.put(product.getId(), product);
		
		return products.size() > initialProductsLength ? product : null;
	}
	//get product details method
	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return products.get(productId);
	}
	//update product details method
	@Override
	public Product updateProduct(Product product) {
		Product oldProduct = products.get(product.getId());
		oldProduct.setName(product.getName());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setQty(product.getQty());
		oldProduct.setManufacturedDate(product.getManufacturedDate());
		oldProduct.setExpiryDate(product.getExpiryDate());
		return oldProduct;
	}
	//remove a product method
	@Override
	public Product removeProduct(int productId) {
		return products.remove(productId);
	}
	//get all product details method with list type return
	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<Product>(products.values());
		return list;
	}
	
}
