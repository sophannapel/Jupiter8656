package com.jupiter.mumscrum.service;

import java.util.List;

import com.jupiter.mumscrum.bean.EmployeeBean;
import com.jupiter.mumscrum.entity.Employee;

public interface EmployeeService {
	
	public Employee getEmployeeByUsername(String username);
	public Employee getEmployee(String empId);
	public boolean isValidUser(String username, String password);
	public boolean saveEmployeeDetails(EmployeeBean employeeBean);
	public List<Employee> getUserListByRole(int roleId);
  public List<Employee> getlistEmployee();
	public void deleteEmpployee(int id);
	public Employee getEmployeeById(int id);
	public void employeeUpdate(EmployeeBean employeeBean);
}

