package com.jupiter.mumscrum.service.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jupiter.mumscrum.bean.EmployeeBean;
import com.jupiter.mumscrum.dataaccess.EmployeeDAO;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	// @Autowired
	// private Employee employee;

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
		isvalid = employeeDAO.isValidUser(username, password);
		return isvalid;
	}

	@Override
	public boolean saveEmployeeDetails(EmployeeBean employeeBean) {
		// TODO Auto-generated method stub

		// Employee employee = new Employee();

		boolean issaved = false;
		Mapper mapper = new DozerBeanMapper();
		Employee employee = mapper.map(employeeBean, Employee.class);

		employee.setFirstname(employeeBean.getFirstname());
		 employee.setLastname(employeeBean.getLastname());
		 employee.setUsername(employeeBean.getUsername());
		 employee.setPassword(employeeBean.getPassword());

		if (employeeBean.getStatus().equals("on"))
			employee.setStatus("Active");
		else
			employee.setStatus("InActive");
		// employee.setRoleId(employeeBean.getRoleId());

		issaved = employeeDAO.saveEmployee(employee);
		return issaved;

	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		return employeeDAO.getEmployeeByUsername(username);
	}

	@Override
	public List<Employee> getUserListByRole(int roleId) {
		return employeeDAO.getUserListByRole(roleId);
	}

@Override
	public List<Employee> getlistEmployee() {
	
			List<Employee> employeeList =employeeDAO.getlistEmployee();
			
			return employeeList;
		
	}

	@Override
	public void deleteEmpployee(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(id);	
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	public void employeeUpdate(EmployeeBean employeeBean) {
		// TODO Auto-generated method stub
		
		Mapper mapper = new DozerBeanMapper();
		Employee employee = mapper.map(employeeBean, Employee.class);
		
		employeeDAO.updateEmployee(employee);
		
	}


}
