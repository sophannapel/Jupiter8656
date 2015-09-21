package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.UserStoryDAO;
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
		List<UserStory> list = query.getResultList();
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}

	@Override
	@Transactional
	public void updateUserStory(UserStory userStory) {
		LOGGER.info("updateUserStory Method, id = " + userStory.getId());
		Query query = entityManager.createQuery("UPDATE UserStory SET description=:description,"
				+ " developerId=:developerId, dueDate=:dueDate, estimateDevEffort=:estimateDevEffort,"
				+ " estimateTestEffort=:estimateTestEffort, name=:name, ownerId=:ownerId,"
				+ " priority=:priority, product=:product, releaseBacklog=:releaseBacklog,"
				+ " sprint=:sprint, startDate=:startDate, testId=:testId WHERE id=:id");
		query.setParameter("description", userStory.getDescription());
		query.setParameter("developerId", userStory.getDeveloperId());
		query.setParameter("dueDate", userStory.getDueDate());
		query.setParameter("estimateDevEffort", userStory.getEstimateDevEffort());
		query.setParameter("estimateTestEffort", userStory.getEstimateTestEffort());
		query.setParameter("name", userStory.getName());
		query.setParameter("ownerId", userStory.getOwnerId());
		query.setParameter("priority", userStory.getPriority());
		query.setParameter("product", userStory.getProduct());
		query.setParameter("releaseBacklog", userStory.getReleaseBacklog());
		query.setParameter("sprint", userStory.getSprint());
		query.setParameter("startDate", userStory.getStartDate());
		query.setParameter("testId", userStory.getTestId());
		query.setParameter("id", userStory.getId());
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void deleteUserStory(int id) {
		LOGGER.info("deleteUserStory Method, id = " + id);
		UserStory us = entityManager.find(UserStory.class, id);
		entityManager.remove(us);
		entityManager.flush();
	}
}
