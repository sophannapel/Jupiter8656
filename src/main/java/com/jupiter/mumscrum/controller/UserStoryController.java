package com.jupiter.mumscrum.controller;

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

import com.jupiter.mumscrum.bean.UserStoryBean;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.entity.Sprint;
import com.jupiter.mumscrum.entity.UserStory;
import com.jupiter.mumscrum.service.UserStoryService;

@Controller
@RequestMapping(value="/userStory")
public class UserStoryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryController.class);
	
	@Autowired
	UserStoryService userStoryService;
	
	@RequestMapping(value = "/userStoryList", method = RequestMethod.GET)
	public String listUserStory(Model model, HttpServletRequest request) {
		LOGGER.info("ListUserStory - Method = GET");
		model.addAttribute("userStoryList", userStoryService.userStoryList());
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		return "userStory/userStoryList";
	}
	
	@RequestMapping(value = "/userStoryForm", method = RequestMethod.POST)
	public String createUserStoryPost(@Valid @ModelAttribute("userStoryBean") UserStoryBean userStoryModel,
			BindingResult result, HttpServletRequest request) {
		
		LOGGER.info("UserStory/userStoryForm - Method = POST");
		if (result.hasErrors()) {
			return "userStory/userStoryForm";
		} else {
			UserStory userStory = new UserStory();
			Employee owner = (Employee) request.getSession().getAttribute("login_id");
			Employee dev = new Employee(); dev.setId(userStoryModel.getDeveloperId());
			Employee test = new Employee(); test.setId(userStoryModel.getTestId());
			Product product = new Product(); product.setId(userStoryModel.getProductId());
			ReleaseBacklog release = new ReleaseBacklog(); release.setId(userStoryModel.getReleaseId());
			Sprint sprint = new Sprint(); sprint.setId(userStoryModel.getSprintId());
			
			userStory.setDescription(userStoryModel.getDescription());
			userStory.setDeveloperId(dev);
			userStory.setTestId(test);
			userStory.setOwnerId(owner);
			userStory.setDueDate(userStoryModel.getDueDate());
			userStory.setStartDate(userStoryModel.getStartDate());
			userStory.setEstimateDevEffort(userStoryModel.getEstimateDevEffort());
			userStory.setEstimateTestEffort(userStoryModel.getEstimateTestEffort());
			userStory.setName(userStoryModel.getName());
			userStory.setPriority(userStoryModel.getPriority());
			userStory.setProduct(product);
			userStory.setReleaseBacklog(release);
			userStory.setSprint(sprint);
			System.out.println(userStory.toString());
			userStoryService.createUserStory(userStory);
			return "redirect:/userStory/userStoryList";
		}	
	}
	
	@RequestMapping(value = "/userStoryForm", method = RequestMethod.GET)
	public String createUserStoryGet(Model model, HttpServletRequest request) {
		LOGGER.info("UserStory/userStoryForm - Method = GET");
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		return "userStory/userStoryForm";
	}
}
