package com.jupiter.mumscrum.service;

import java.util.List;

import com.jupiter.mumscrum.entity.Product;

public interface ProductService {
	
	public List<Product> listProduct();
	public void createProduct(Product product);
	public Product getProductById(int id);
	public void deleteProduct(int id);
}
