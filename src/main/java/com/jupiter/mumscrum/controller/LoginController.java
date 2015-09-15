package com.jupiter.mumscrum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jupiter.mumscrum.bean.EmployeeBean;
import com.jupiter.mumscrum.service.EmployeeService;

@Controller
public class LoginController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayLogin(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("employeeBean") EmployeeBean employeeBean) {

		boolean isValidUser = employeeService.isValidUser(employeeBean.getUsername(), employeeBean.getPassword());
		if (isValidUser)
			return "product";
		else
			return "login";
	}
}
