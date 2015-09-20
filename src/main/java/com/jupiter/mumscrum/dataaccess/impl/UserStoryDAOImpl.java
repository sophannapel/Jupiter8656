package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.UserStoryDAO;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.UserStory;

@Repository
public class UserStoryDAOImpl implements UserStoryDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryDAOImpl.class);

	@Override
	@Transactional
	public void createUserStory(UserStory userStory) {
		LOGGER.info("Save user story : " +userStory.toString());
		entityManager.merge(userStory);
		entityManager.flush();
		
	}

	@Override
	@Transactional
	public List<UserStory> userStoryList() {
		LOGGER.info("userStoryList Method call");
		List<UserStory> userStoryList = entityManager.createQuery("SELECT u FROM UserStory u").getResultList();
		for(UserStory u : userStoryList)
			LOGGER.info("User story list::" + u);
		return userStoryList;
	}

	@Override
	@Transactional
	public UserStory getUserStoryById(int id) {
		LOGGER.info("getUserStoryById Method call");
		Query query = entityManager.createQuery("FROM UserStory WHERE id=:id");
		query.setParameter("id", id);
		return (UserStory) query.getResultList().get(0);
	}

	@Override
	@Transactional
	public void updateUserStory(UserStory userStory) {
		LOGGER.info("updateUserStory Method call -------");
		System.out.println(userStory.toString());
		UserStory us = entityManager.find(UserStory.class, userStory.getId());
		//System.out.println(us.toString());
		us.setPriority(userStory.getPriority());
		entityManager.flush();
	}

}
