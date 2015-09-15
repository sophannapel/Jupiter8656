package com.jupiter.mumscrum.dataaccess;

import java.util.List;

import com.jupiter.mumscrum.entity.Product;

public interface ProductDAO {
	
	public List<Product> listProduct();
	public void createProduct(Product product);
}
