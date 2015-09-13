package com.jupiter.mumscrum.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

		List<Employee> employeeList = entityManager.createQuery("SELECT t FROM Employee t").getResultList();
		
		System.out.println(employeeList.toString());
		
		for(Employee emp : employeeList){
			LOGGER.info("Employee List::"+ emp);
		}
		return employeeList.get(1);
	}

}
