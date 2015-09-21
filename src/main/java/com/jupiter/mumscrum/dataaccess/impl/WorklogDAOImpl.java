package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.WorklogDAO;
import com.jupiter.mumscrum.entity.Worklog;

@Repository
public class WorklogDAOImpl implements WorklogDAO {

	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryDAOImpl.class);
	
	@Override
	@Transactional
	public void createWorklog(Worklog worklog) {
		LOGGER.info("Save worklog : " + worklog.toString());
		entityManager.merge(worklog);
		entityManager.flush();
		
	}

	@Override
	public List<Worklog> worklogList(int userStoryId) {
		LOGGER.info("worklogList Method call");
		System.out.println("-------------------->"+userStoryId);
		Query q = entityManager.createQuery("FROM Worklog WHERE userStoryId = :userStoryId");
		q.setParameter("userStoryId", userStoryId);
		List<Worklog> worklogList = q.getResultList();
		
		for(Worklog w : worklogList)
			LOGGER.info("User story list::" + w);
		return worklogList;
	}

}
