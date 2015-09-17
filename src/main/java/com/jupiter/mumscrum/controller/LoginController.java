package com.jupiter.mumscrum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jupiter.mumscrum.bean.EmployeeBean;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.service.EmployeeService;

@Controller

@Scope("session")

public class LoginController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("employeeBean") EmployeeBean employeeBean, Model model) {
		boolean isValidUser = employeeService.isValidUser(employeeBean.getUsername(), employeeBean.getPassword());
		if(isValidUser == true) {
			Employee emp =  employeeService.getEmployeeByUsername(employeeBean.getUsername());
			model.addAttribute("userId", emp.getId());
			//return "/product/productForm";
			return "userStory/userStoryList";
		}
		else
			return "login";
	}
}
