package com.jupiter.mumscrum.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jupiter.mumscrum.bean.EmployeeBean;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.service.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		//ModelAndView model = new ModelAndView("login");
		Employee emp = employeeService.getEmployee(1);

				model.addAttribute("id", emp.getEmpid());
		model.addAttribute("name", emp.getFirstname());

		return "home";
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model = new ModelAndView("login");
		EmployeeBean employeeBean = new EmployeeBean();
		model.addObject("employeeBean", employeeBean);
		return model;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	//@RequestMapping(value = "/login")
	public ModelAndView executeLogin (HttpServletRequest request, HttpServletResponse response, @ModelAttribute("employeeBean")EmployeeBean employeeBean) 
	{
		
		System.out.println("jejeej");
		ModelAndView model= null;
		try {
			boolean isValidUser = employeeService.isValidUser(employeeBean.getUsername(), employeeBean.getPassword());
			
				if(isValidUser)
				{
					System.out.println("User Login Successful");
					request.setAttribute("loggedInUser", employeeBean.getUsername());
					model = new ModelAndView("welcome");
				}
				else
				{
					model = new ModelAndView("login");
					model.addObject("employeeBean", employeeBean);
					request.setAttribute("message", "Invalid credentials!!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	
		
		return model;
		}
	

}


