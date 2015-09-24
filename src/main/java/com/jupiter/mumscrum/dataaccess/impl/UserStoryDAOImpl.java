package com.jupiter.mumscrum.dataaccess.impl;

import java.util.ArrayList;
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
		LOGGER.info("Save user story : " +userStory.getId());
		entityManager.merge(userStory);
		entityManager.flush();	
	}

	@Override
	@Transactional
	public List<UserStory> userStoryList() {
		LOGGER.info("userStoryList Method call");
		List<UserStory> userStoryList = entityManager.createQuery("SELECT u FROM UserStory u").getResultList();
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

	@Override
	@Transactional
	public List<UserStory> getUserStoryForRelease(int releaseId) {
		LOGGER.info("getUserStoryForRelease, id = " + releaseId);
		
		Query query = entityManager.createQuery("FROM UserStory WHERE sprint.id IS NULL AND releaseBacklog.id=:id");
		query.setParameter("id", releaseId);
		System.out.println("Inside getUserStoryForRelease");
		return query.getResultList();
	}

	public List<UserStory> userStoryListForDevTest(int empID) {
		Query q = entityManager.createQuery("FROM UserStory WHERE developerId.id = :empID OR testId.id = :empID");
		q.setParameter("empID", empID);
		List<UserStory> userStoryList = q.getResultList();
		return userStoryList;
	}

	@Override
	@Transactional
	public void updateSprintForUserStory(UserStory userStory, int sprintId) {
		LOGGER.info("Updating UserStory id "+userStory.getId()+"for sprint id::"+sprintId);
		Query query = entityManager.createQuery("UPDATE UserStory SET sprintid=:sprintId WHERE id=:id");
		query.setParameter("sprintId", sprintId);
		query.setParameter("id", userStory.getId());
		query.executeUpdate();
	}

	public void updateUserStoryForDevTest(UserStory userStory) {
		Query query = entityManager.createQuery("UPDATE UserStory SET dueDate=:dueDate, estimateDevEffort=:estimateDevEffort,"
				+ " estimateTestEffort=:estimateTestEffort,"
				+ " startDate=:startDate WHERE id=:id");
		query.setParameter("dueDate", userStory.getDueDate());
		query.setParameter("estimateDevEffort", userStory.getEstimateDevEffort());
		query.setParameter("estimateTestEffort", userStory.getEstimateTestEffort());
		query.setParameter("startDate", userStory.getStartDate());
		query.setParameter("id", userStory.getId());
		query.executeUpdate();
		
	}

}
