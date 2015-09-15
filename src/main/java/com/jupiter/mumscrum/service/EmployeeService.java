package com.jupiter.mumscrum.service;

import com.jupiter.mumscrum.entity.Employee;

public interface EmployeeService {
	
	
	public Employee getEmployee(int empId);

	public boolean isValidUser(String username, String password);
	
}
