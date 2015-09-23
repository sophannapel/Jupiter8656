package com.jupiter.mumscrum.service;

import java.util.List;

import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.UserStory;

public interface ProductService {
	
	public List<Product> listProduct();
	public void createProduct(Product product);
	public Product getProductById(int id);
	public void deleteProduct(int id);
	public void updateProduct(Product product);
}
