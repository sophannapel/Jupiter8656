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
	
}
