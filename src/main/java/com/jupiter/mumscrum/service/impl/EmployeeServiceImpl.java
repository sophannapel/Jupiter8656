package com.jupiter.mumscrum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.dataaccess.EmployeeDAO;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void setPersonDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	public Employee getEmployee(String empId) {
		
		return employeeDAO.getEmployee(empId);
	}

	@Override
	public boolean isValidUser(String username, String password) {

			boolean isvalid = false;
			isvalid = employeeDAO.isValidUser(username,password);
			return isvalid;
		
		
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		return employeeDAO.getEmployeeByUsername(username);
	}

}
