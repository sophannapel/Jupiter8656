package com.jupiter.mumscrum.dataaccess;

import java.util.List;

import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.UserStory;

public interface ProductDAO {
	
	public List<Product> listProduct();
	public void createProduct(Product product);
	public Product getProductById(int id);
	public void deleteProduct(int id);
}
