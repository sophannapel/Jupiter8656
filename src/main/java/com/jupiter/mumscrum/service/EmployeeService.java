package com.jupiter.mumscrum.service;

import com.jupiter.mumscrum.entity.Employee;

public interface EmployeeService {
	
	public Employee getEmployeeByUsername(String username);
	public Employee getEmployee(String empId);
	public boolean isValidUser(String username, String password);
}
