package com.jupiter.mumscrum.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jupiter.mumscrum.bean.EmployeeBean;
import com.jupiter.mumscrum.service.EmployeeService;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.GET)
	public String employeePage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("employee inside ");
		return "employee";
	}
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String employee(@Valid @ModelAttribute("employeeBean")  EmployeeBean employeeBean, BindingResult result) {
		
		Logger.getLogger("Enter my use case");
		
		System.out.println(employeeBean.getFirstname());
		System.out.println(employeeBean.getLastname());
		System.out.println(employeeBean.getUsername());
		System.out.println(employeeBean.getPassword());
		System.out.println(employeeBean.getStatus());
		
		boolean isValidUser = employeeService.saveEmployeeDetails(employeeBean);

		
		return "redirect:/employee/employeeList";
	
	}
	
	
//	@RequestMapping(value = "/employee/EmployeeList", method = RequestMethod.GET)
//	public String employeeList(HttpServletRequest request, HttpServletResponse response) {
//		return "employeeList";
//	}
	
	
	@RequestMapping(value = "/employee/employeeList", method = RequestMethod.GET)
	public String  employeeList(Model model)
	{
		
		
		model.addAttribute("listEmployee", employeeService.getlistEmployee() );
		
		return "employeeList";
		
	}
	
	@RequestMapping(value = "employee/deleteEmployee", method = RequestMethod.GET)
	public String deleteSprint(@RequestParam("id") int id ,Model model) {
		
		
		employeeService.deleteEmpployee(id);
		return "redirect:/employee/employeeList";
	}
	
	@RequestMapping(value = "/employee/employeeEdit", method = RequestMethod.GET)
	public String editEmployee(@RequestParam("id") int id ,Model model,HttpServletRequest request) {
		
		
			
			//LOGGER.info("Edit method for Sprint id:: "+ id);
			model.addAttribute("employeeBean", new EmployeeBean());

//			Employee emp = (Employee) request.getSession().getAttribute("login_id");
//			model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
//			model.addAttribute("role", emp.getRole().getName());
			model.addAttribute("employee",  employeeService.getEmployeeById(id));
		
			return "employeeUpdate";
		
	}
	
	@RequestMapping(value = "employee/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@Valid @ModelAttribute("employeeBean") EmployeeBean employeeBean, BindingResult bindingResult) {

//		LOGGER.info("Updates data for Sprint ::" + sprintBean.getId());	
		if(bindingResult.hasErrors())
			return "employee/employeeUpdate";
		employeeService.employeeUpdate(employeeBean);
		return "redirect:/employee/employeeList";
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
