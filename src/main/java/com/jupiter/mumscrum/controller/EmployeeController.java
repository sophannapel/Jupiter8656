package com.jupiter.mumscrum.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jupiter.mumscrum.bean.EmployeeBean;
import com.jupiter.mumscrum.service.EmployeeService;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employeePage(HttpServletRequest request, HttpServletResponse response) {
		return "employee";
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String employee(@ModelAttribute("employeeBean")  EmployeeBean employeeBean, BindingResult result) {
		
		Logger.getLogger("Enter my use case");
		
		System.out.println(employeeBean.getFirstname());
		System.out.println(employeeBean.getLastname());
		System.out.println(employeeBean.getUsername());
		System.out.println(employeeBean.getPassword());
		System.out.println(employeeBean.getStatus());
		
		boolean isValidUser = employeeService.saveEmployeeDetails(employeeBean);

		
		return "welcome";
	
	}
	
	
	
	
	
	
	@RequestMapping(value = "/employee/Rest", method = RequestMethod.GET)
	//@Produces(MediaType.APPLICATION_JSON)

	public @ResponseBody EmployeeBean testRest(HttpServletRequest request,HttpServletResponse response)
	{
		EmployeeBean employeeBean= new EmployeeBean();
		
		employeeBean.setFirstname("hari");
		employeeBean.setLastname("hari");
		employeeBean.setUsername("hari");
		employeeBean.setPassword("hari");
		
		
		
		return employeeBean;
		
		//return "Hello Rest";
		
	}
}
