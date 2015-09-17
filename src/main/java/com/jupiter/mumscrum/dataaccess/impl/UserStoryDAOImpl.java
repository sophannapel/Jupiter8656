package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jupiter.mumscrum.dataaccess.UserStoryDAO;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.UserStory;

public class UserStoryDAOImpl implements UserStoryDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryDAOImpl.class);

	@Override
	public void createUserStory(UserStory userStory) {
		LOGGER.info("Save user story : " +userStory.toString());
		entityManager.persist(userStory);
		entityManager.flush();
	}

	@Override
	public List<UserStory> userStoryList() {
		List<UserStory> userStoryList = entityManager.createQuery("SELECT s FROM UserStory t").getResultList();
		for(UserStory u : userStoryList)
			LOGGER.info("User story list::" + u);
		return userStoryList;
	}

}
