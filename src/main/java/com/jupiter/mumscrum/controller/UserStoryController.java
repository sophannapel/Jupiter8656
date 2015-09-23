package com.jupiter.mumscrum.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jupiter.mumscrum.bean.UserStoryBean;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.entity.Sprint;
import com.jupiter.mumscrum.entity.UserStory;
import com.jupiter.mumscrum.service.ProductService;
import com.jupiter.mumscrum.service.ReleaseBacklogService;
import com.jupiter.mumscrum.service.UserStoryService;
import com.jupiter.mumscrum.util.Utility;

@Controller
@RequestMapping(value="/userStory")
public class UserStoryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryController.class);
	
	@Autowired
	UserStoryService userStoryService;
	
	@Autowired
	ReleaseBacklogService releaseBacklogService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/userStoryList", method = RequestMethod.GET)
	public String listUserStory(Model model, HttpServletRequest request) {
		LOGGER.info("ListUserStory - Method = GET");
		model.addAttribute("userStoryList", userStoryService.userStoryList());
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		return "userStory/userStoryList";
	}
	
	@RequestMapping(value = "/userStoryListForDevTest", method = RequestMethod.GET)
	public String listUserStoryForDevTest(Model model, HttpServletRequest request) {
		LOGGER.info("ListUserStory - Method = GET");
		
		//employee information
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		int empId = emp.getId();
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		
		model.addAttribute("userStoryListForDevTest", userStoryService.userStoryListForDevTest(empId));
		return "userStory/userStoryListForDevTest";
	}
	
	@RequestMapping(value = "/userStoryForm", method = RequestMethod.POST)
	public String createUserStoryPost(@Valid @ModelAttribute("userStoryBean") UserStoryBean userStoryModel,
			BindingResult result, HttpServletRequest request, Model model) {
		
		LOGGER.info("UserStory/userStoryForm - Method = POST");
		if (result.hasErrors()) {
			model.addAttribute("productList", productService.listProduct()); //product drop down list for user story 
			return "userStory/userStoryForm";
		} else {
			UserStory userStory = new UserStory();
			Employee owner = (Employee) request.getSession().getAttribute("login_id");
			Employee dev = new Employee(); 
			Employee test = new Employee(); 
			Product product = new Product(); product.setId(userStoryModel.getProductId());
			ReleaseBacklog release = new ReleaseBacklog(); 
			Sprint sprint = new Sprint(); 
			
			if(userStoryModel.getReleaseId()!=null) {
				release.setId(userStoryModel.getReleaseId());
				userStory.setReleaseBacklog(release);
			}
			if(userStoryModel.getSprintId()!=null) {
				sprint.setId(userStoryModel.getSprintId());
				userStory.setSprint(sprint);
			}
			
			if(userStoryModel.getDeveloperId()!=null) {
				dev.setId(userStoryModel.getDeveloperId());
				userStory.setDeveloperId(dev);
			}
				
			if(userStoryModel.getTestId()!=null) {
				test.setId(userStoryModel.getTestId());
				userStory.setTestId(test);
			}
			
			userStory.setDescription(userStoryModel.getDescription());
			userStory.setOwnerId(owner);
			userStory.setDueDate(userStoryModel.getDueDate());
			userStory.setStartDate(userStoryModel.getStartDate());
			userStory.setEstimateDevEffort(userStoryModel.getEstimateDevEffort());
			userStory.setEstimateTestEffort(userStoryModel.getEstimateTestEffort());
			userStory.setName(userStoryModel.getName());
			userStory.setPriority(userStoryModel.getPriority());
			userStory.setProduct(product);
			
			if(!request.getSession().getAttribute("userStoryId").equals("-1")) {
				userStory.setId(Integer.valueOf(request.getSession().getAttribute("userStoryId").toString()));
				userStoryService.updateUserStory(userStory);
				request.getSession().removeAttribute("userStoryId");			
			}
			else {
				userStoryService.createUserStory(userStory);
			}
			return "redirect:/userStory/userStoryList";
		}
	}
	
	@RequestMapping(value = "/userStoryForm", method = RequestMethod.GET)
	public String createUserStoryGet(Model model, HttpServletRequest request) {
		LOGGER.info("UserStory/userStoryForm - Method = GET");
		if(request.getParameter("userStoryId")!=null) { //select of existing user story to update
			model.addAttribute("userStory", userStoryService.getUserStoryById(Integer.valueOf(request.getParameter("userStoryId"))));
			request.getSession().setAttribute("userStoryId", request.getParameter("userStoryId"));
			model.addAttribute("title", "Edit User Story");
		}
		else {
			request.getSession().setAttribute("userStoryId", "-1"); //create new user story
			model.addAttribute("title", "Add New User Story");
		}
		model.addAttribute("userStoryBean", new UserStoryBean()); //for commandName="userStoryBean" on userStoryForm.jsp
		model.addAttribute("productList", productService.listProduct()); //product drop down list for user story 
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		return "userStory/userStoryForm";
	}
	
	@RequestMapping(value = "/userStoryFormForDevTest", method = RequestMethod.GET)
	public String createUserStoryGetForDevTest(Model model, HttpServletRequest request) {
		LOGGER.info("UserStory/userStoryFormForDevTest - Method = GET");
		if(request.getParameter("userStoryId")!=null) { //select of existing user story to update
			model.addAttribute("userStory", userStoryService.getUserStoryById(Integer.valueOf(request.getParameter("userStoryId"))));
			request.getSession().setAttribute("userStoryId", request.getParameter("userStoryId"));
			model.addAttribute("title", "Update Estimate Effort");
		}
		
		model.addAttribute("userStoryBean", new UserStoryBean()); //for commandName="userStoryBean" on userStoryForm.jsp
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		return "userStory/userStoryFormForDevTest";
	}
	
	@RequestMapping(value = "/userStoryFormForDevTest", method = RequestMethod.POST)
	public String createUserStoryPostForDevTest(@ModelAttribute("userStoryBean") UserStoryBean userStoryModel,
			BindingResult result, HttpServletRequest request, Model model)  {
		
		if (result.hasErrors()) {
			return "userStory/userStoryFormForDevTest";
		} else {
			UserStory userStory = new UserStory();
			userStory.setDueDate(userStoryModel.getDueDate());
			userStory.setStartDate(userStoryModel.getStartDate());
			userStory.setEstimateDevEffort(userStoryModel.getEstimateDevEffort());
			userStory.setEstimateTestEffort(userStoryModel.getEstimateTestEffort());
			
			if(!request.getSession().getAttribute("userStoryId").equals("-1")) {
				userStory.setId(Integer.valueOf(request.getSession().getAttribute("userStoryId").toString()));
				userStoryService.updateUserStoryForDevTest(userStory);
				request.getSession().removeAttribute("userStoryId");			
			}
			return "redirect:/userStory/userStoryListForDevTest";
		}
	}
	
	@RequestMapping(value = "/userStoryDelete", method = RequestMethod.GET)
	public String deleteUserStory(Model model, HttpServletRequest request) {
		LOGGER.info("deleteUserStory - Method");
		int userStoryId = Integer.valueOf(request.getParameter("userStoryId"));
		userStoryService.deleteUserStory(userStoryId);
		return "redirect:/userStory/userStoryList";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getReleasesByProductId")
	@ResponseBody
	public String getReleasesByProductId(@RequestParam("productId") int id) {
		System.out.println("------------"+id);
		List<ReleaseBacklog> releases = releaseBacklogService.listReleaseByProductId(id);
		String json =  Utility.generateJSON(releases);
		LOGGER.info(json.toString());
		return json;
	}

}
