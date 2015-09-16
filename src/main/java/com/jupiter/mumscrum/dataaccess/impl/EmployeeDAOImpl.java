package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jupiter.mumscrum.dataaccess.EmployeeDAO;
import com.jupiter.mumscrum.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Employee getEmployee(String id) {
		System.out.println("Hello " + entityManager);

		@SuppressWarnings("unchecked")
		List<Employee> employeeList = entityManager.createQuery("SELECT t FROM Employee t").getResultList();

		for (Employee emp : employeeList) {
			LOGGER.info("Employee List::" + emp);
		}
		return employeeList.get(0);
	}

	@Override
	public boolean isValidUser(String username, String password) {

		Query isvalid = entityManager.createQuery(" from Employee where username = :username and password = :password");
		isvalid.setParameter("username", username);
		isvalid.setParameter("password", password);
		List<Employee> employeeList = isvalid.getResultList();
		LOGGER.info("Login Employee Information::" + employeeList);
		if (employeeList.isEmpty()) 
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		entityManager.persist(employee);
		entityManager.flush();
		return false;
	}

}
