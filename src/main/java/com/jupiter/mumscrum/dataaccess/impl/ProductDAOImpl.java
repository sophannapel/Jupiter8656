package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.ProductDAO;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.UserStory;

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
	@Transactional
	public void createProduct(Product product) {
		LOGGER.info("Create new product, product = " + product);
		entityManager.persist(product);
		entityManager.flush();
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		LOGGER.info("getProductById method call, id = " + id);
		Query query = entityManager.createQuery("FROM Product WHERE id=:id");
		query.setParameter("id", id);
		List<Product> product = query.getResultList();
		if(product.isEmpty())
			return null;
		else 
			return product.get(0);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		LOGGER.info("deleteProduct Method, id = " + id);
		Product product = entityManager.find(Product.class, id);
		//Product product = entityManager.getReference(Product.class, id);
		entityManager.remove(product);
		//entityManager.flush();
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		LOGGER.info("updateProduct Method, id = " + product.getId());
		Query query = entityManager.createQuery("UPDATE Product SET description=:description,"
				+ " dueDate=:dueDate,"
				+ " name=:name, "
				+ " startDate=:startDate, "
				+ " status=:status WHERE id=:id");
		query.setParameter("description", product.getDescription());
		query.setParameter("dueDate", product.getDueDate());
		query.setParameter("name", product.getName());
		query.setParameter("startDate", product.getStartDate());
		query.setParameter("status", product.getStatus());
		query.setParameter("id", product.getId());
		query.executeUpdate();
	}
}
