package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.ReleaseBacklogDAO;
import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.entity.UserStory;

@Repository
public class ReleaseBacklogDAOImpl implements ReleaseBacklogDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReleaseBacklogDAOImpl.class);
		
	@Override
	@Transactional
	public List<ReleaseBacklog> listRelease() {
	
		List<ReleaseBacklog> releases = entityManager.createQuery("SELECT t FROM ReleaseBacklog t", ReleaseBacklog.class).getResultList();
		for(ReleaseBacklog r: releases)
			LOGGER.info("Product list::" + r);
		
		return releases;
	}

	@Override
	@Transactional
	public List<ReleaseBacklog> listReleaseByProductId(int productId) {
		Query query = entityManager.createQuery("FROM ReleaseBacklog WHERE product.id = :productId");
		query.setParameter("productId", productId);
		List<ReleaseBacklog> releases = query.getResultList();
		return releases;
	}

	@Override
	@Transactional
	public void createRelease(ReleaseBacklog release) {
		//entityManager.persist(release);
		entityManager.merge(release);
		//ntityManager.flush();		
	}

	@Override
	@Transactional
	public ReleaseBacklog getReleaseBacklogById(int releaseId) {
		Query query = entityManager.createQuery("FROM ReleaseBacklog WHERE id=:id");
		query.setParameter("id", releaseId);
		List<ReleaseBacklog> list = query.getResultList();
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}

	@Override
	@Transactional
	public void updateReleaseBacklog(ReleaseBacklog releaseBacklog) {
		LOGGER.info("updateRelease Method, id = " + releaseBacklog.getId());
		Query query = entityManager.createQuery("UPDATE ReleaseBacklog SET descriptioon=:descriptioon,"
				+ " dueDate=:dueDate,"
				+ " name=:name, "
				+ " product=:product, "
				+ " startDate=:startDate, "
				+ " employee=:employee, "
				+ " type=:type WHERE id=:id");
		query.setParameter("descriptioon", releaseBacklog.getDescriptioon());
		query.setParameter("dueDate", releaseBacklog.getDueDate());
		query.setParameter("name", releaseBacklog.getName());
		query.setParameter("product", releaseBacklog.getProduct());
		query.setParameter("startDate", releaseBacklog.getStartDate());
		query.setParameter("employee", releaseBacklog.getEmployee());
		query.setParameter("type", releaseBacklog.getType());
		query.setParameter("id", releaseBacklog.getId());
		System.out.println(query.toString());
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void deleteReleaseBacklog(int id) {
		LOGGER.info("deleteReleaseBacklog Method, id = " + id);
		ReleaseBacklog rb = entityManager.getReference(ReleaseBacklog.class, id);
		entityManager.remove(rb);
	}
	
}
