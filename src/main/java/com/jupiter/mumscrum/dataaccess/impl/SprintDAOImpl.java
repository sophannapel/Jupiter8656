package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.SprintDAO;
import com.jupiter.mumscrum.entity.Coordinates;
import com.jupiter.mumscrum.entity.Sprint;

@Repository
public class SprintDAOImpl implements SprintDAO{

	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(SprintDAOImpl.class);
	
	
	@Override
	@Transactional
	public int insertSprint(Sprint sprint) {
		
		LOGGER.info("Saving new Sprint information for sprint");
		
		entityManager.persist(sprint);
		entityManager.flush();
		
		return sprint.getId();
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
	
	@Override
	@Transactional
	public void deleteSprint(int id){
		  LOGGER.info("Deleting Sprint for id::"+id);
		  Sprint sprint = entityManager.find(Sprint.class, id);
		  entityManager.remove(sprint);
		  
		  
	}
	
	@Override
	public Long getTotalEstimate(int id){
		LOGGER.info("Retriving Total Estimate for Sprint id::"+id);
		String hql = "SELECT SUM (estimateDevEffort+ estimateTestEffort) FROM UserStory WHERE sprintId =:id";
		TypedQuery<Long> query = entityManager.createQuery(hql,Long.class);
		query.setParameter("id", id);
		Long results = query.getSingleResult();	
		if (results == null) return new Long(0);
		else return results;
	
	}
	
	@Override
	public List<Coordinates>  getWorklogDataSet(int id){		
		String hql = "SELECT SUM(actualEffort) AS workHours, DATE(modifiedDate) AS day FROM  Worklog WHERE userstoryid IN (SELECT id FROM UserStory WHERE sprintid = :id) GROUP BY modifiedDate ORDER BY modifieddate";
		Query query =	entityManager.createQuery(hql);
		query.setParameter("id", id);
		List<Coordinates> results = query.getResultList(); 
		
		return results;
	}

	@Override
	@Transactional
	public List<Sprint> getSprintsByReleaseId(int releaseId) {
		LOGGER.info("Get sprint by release Id::" + releaseId);
		Query query = entityManager.createQuery("FROM Sprint WHERE releaseBacklog.id = :releaseId");
		query.setParameter("releaseId", releaseId);
		List<Sprint> sprints = query.getResultList();
		return sprints;
	}
}
