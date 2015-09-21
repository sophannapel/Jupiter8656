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
import com.jupiter.mumscrum.bean.WorklogBean;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.entity.Sprint;
import com.jupiter.mumscrum.entity.UserStory;
import com.jupiter.mumscrum.entity.Worklog;
import com.jupiter.mumscrum.service.UserStoryService;
import com.jupiter.mumscrum.service.WorklogService;

@Controller
@RequestMapping(value="/worklog")
public class WorklogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorklogController.class);
	
	@Autowired
	WorklogService worklogService;
	
	@Autowired
	UserStoryService userstoryService;
	
	@RequestMapping(value = "/worklogList", method = RequestMethod.GET)
	public String listUserStory(Model model, HttpServletRequest request) {
		int userStoryId = Integer.valueOf(request.getParameter("userStoryId"));
		String userStoryName = userstoryService.getUserStoryById(userStoryId).getName();
		model.addAttribute("title", userStoryName);
		LOGGER.info("ListWorklog - Method = GET");
		model.addAttribute("worklogList", worklogService.worklogList(userStoryId));
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		return "worklog/worklogList";
	}
	
	@RequestMapping(value = "/worklogForm", method = RequestMethod.GET)
	public String createWorklogGet(Model model, HttpServletRequest request) {
		LOGGER.info("Worklog/worklogForm - Method = GET");

		request.getSession().setAttribute("worklogId", "-1"); //create new worklog
		model.addAttribute("title", "Add New Worklog");
		request.getSession().setAttribute("userStoryId", request.getParameter("userStoryId"));
		model.addAttribute("worklogBean", new WorklogBean()); //for commandName="worklogBean" on worklogForm.jsp
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		model.addAttribute("userStoryId",request.getParameter("userStoryId"));
		return "worklog/worklogForm";
	}
	
	@RequestMapping(value = "/worklogForm", method = RequestMethod.POST)
	public String createUserStoryPost(@Valid @ModelAttribute("worklogBean") WorklogBean worklogModel,
			BindingResult result, HttpServletRequest request, Model model) {
		
		LOGGER.info("worklog/worklogForm - Method = POST");
		
			Worklog worklog = new Worklog();
			if(result.hasErrors()){
				Employee emp = (Employee) request.getSession().getAttribute("login_id");
				model.addAttribute("title", "Add New Worklog");
				model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
				model.addAttribute("role", emp.getRole().getName());
				return "worklog/worklogForm";
			}
			else{
				UserStory userstory = new UserStory();
				userstory.setId(Integer.valueOf(request.getSession().getAttribute("userStoryId").toString()));
				request.getSession().removeAttribute("userStoryId");
				worklog.setUserstory(userstory);
				worklog.setActualEffort(worklogModel.getActualEffort());
				System.out.println("----------------->" + worklogModel.getModifiedDate());
				worklog.setModifiedDate(worklogModel.getModifiedDate());
				worklog.setEffortType(worklogModel.getEffortType());
				
				System.out.println("create worklog");
				worklogService.createWorklog(worklog);

				return "redirect:/userStory/userStoryList";
			}
			

	}
}
