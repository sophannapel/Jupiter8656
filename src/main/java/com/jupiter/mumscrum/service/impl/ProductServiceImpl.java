package com.jupiter.mumscrum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.dataaccess.ProductDAO;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDao;
	
	@Override
	public List<Product> listProduct() {
		return productDao.listProduct();
	}

	@Override
	public void createProduct(Product product) {
		productDao.createProduct(product);
	}
	
}
