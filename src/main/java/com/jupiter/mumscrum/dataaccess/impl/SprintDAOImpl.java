package com.jupiter.mumscrum.dataaccess.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.SprintDAO;
import com.jupiter.mumscrum.entity.Sprint;

@Repository
public class SprintDAOImpl implements SprintDAO{

	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	
	@Override
	@Transactional
	public void insertSprint(Sprint sprint) {
		
		LOGGER.info("Saving new Sprint information for sprint");
		
		entityManager.persist(sprint);
		entityManager.flush();
	}

}
