package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.RoleDAO;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleDAOImpl.class);

	@Override
	@Transactional
	public Role getRole(int id) {
		Query query = entityManager.createQuery(" from Role where id = :id");
		query.setParameter("id", id);
		List<Role> role = query.getResultList();
		System.out.println(role.get(0).toString());
		return role.get(0);
	}

}
