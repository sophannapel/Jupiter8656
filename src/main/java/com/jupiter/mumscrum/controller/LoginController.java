package com.jupiter.mumscrum.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jupiter.mumscrum.bean.Login;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.entity.Role;
import com.jupiter.mumscrum.service.EmployeeService;
import com.jupiter.mumscrum.service.RoleService;

@Controller
public class LoginController {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		model.asMap().clear(); // remove mapping from map
		model.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@Valid @ModelAttribute("login") Login loginModel, BindingResult result,
			HttpServletRequest request, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("login", loginModel);
			return "login";
		} else {
			boolean isValidUser = employeeService.isValidUser(loginModel.getUsername(), loginModel.getPassword());
			if (isValidUser == true) {
				Employee emp = employeeService.getEmployeeByUsername(loginModel.getUsername());
				Role role = roleService.getRole(emp.getRoleId());
				request.getSession().setAttribute("login_id", emp);
				request.getSession().setAttribute("role", role);
				LOGGER.info(emp.getId() + "@" + request.getRemoteAddr() + ", access on " + new Date());
				return "redirect:/product/productForm";
			} else
				return "login";
		}
	}
}
