package com.jupiter.mumscrum.dataaccess;

import com.jupiter.mumscrum.entity.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployee(String id);
	public boolean isValidUser(String username, String password);
	public Employee getEmployeeByUsername(String username);
}
