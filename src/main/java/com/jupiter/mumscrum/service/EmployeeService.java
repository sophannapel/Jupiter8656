package com.jupiter.mumscrum.service;

import com.jupiter.mumscrum.bean.EmployeeBean;
import com.jupiter.mumscrum.entity.Employee;

public interface EmployeeService {
	
	
	public Employee getEmployee(String empId);
	public boolean isValidUser(String username, String password);
	public boolean saveEmployeeDetails(EmployeeBean employeeBean);
}
