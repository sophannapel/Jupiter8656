package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.StatusDAO;
import com.jupiter.mumscrum.entity.Status;

@Repository
public class StatusDAOImpl implements StatusDAO {

	@PersistenceContext
	private EntityManager entityManager;	
	
	@Override
	@Transactional
	public List<Status> statusList() {
		List<Status> list = entityManager.createQuery("SELECT s FROM Status s").getResultList();
		if(list.isEmpty())
			return null;
		else 
			return list;
	}

}
