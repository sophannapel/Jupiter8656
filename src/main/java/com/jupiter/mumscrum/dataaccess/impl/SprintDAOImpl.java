package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

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
	private static final Logger LOGGER = LoggerFactory.getLogger(SprintDAOImpl.class);
	
	
	@Override
	@Transactional
	public void insertSprint(Sprint sprint) {
		
		LOGGER.info("Saving new Sprint information for sprint");
		
		entityManager.persist(sprint);
		entityManager.flush();
	}


	@Override	
	public List<Sprint> listSprint() {
		LOGGER.info("Retriving Sprint List");
		
		List<Sprint> sprints = entityManager.createQuery("SELECT t FROM Sprint t", Sprint.class).getResultList();
		return sprints;
	}


	@Override
	public Sprint getSprintById(int id) {
		LOGGER.info("Retriving Sprint for id::"+id);
		return entityManager.find(Sprint.class, id);
	}


	@Override
	@Transactional
	public void updateSprint(Sprint sprint) {
		LOGGER.info("Updating Sprint for id::"+sprint.getId());
		entityManager.merge(sprint);
		entityManager.flush();		
	}

}
