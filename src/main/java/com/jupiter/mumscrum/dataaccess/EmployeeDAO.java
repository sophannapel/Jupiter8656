package com.jupiter.mumscrum.dataaccess;

import java.util.List;

import com.jupiter.mumscrum.entity.Employee;


@Repository
public interface EmployeeDAO   {
	
	public Employee getEmployee(String id);
	public boolean isValidUser(String username, String password);
	public Employee getEmployeeByUsername(String username);
  public boolean saveEmployee(Employee employee);
 public List<Employee> getUserListByRole(int roleId);
public List<Employee> getlistEmployee();
public void deleteEmployee(int id);

}
