package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.ProductDAO;
import com.jupiter.mumscrum.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	@Override
	@Transactional
	public List<Product> listProduct() {
		
		List<Product> products = entityManager.createQuery("SELECT t FROM Product t", Product.class).getResultList();
		for(Product p : products)
			LOGGER.info("Product list::" + p);
		return products;
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

}
