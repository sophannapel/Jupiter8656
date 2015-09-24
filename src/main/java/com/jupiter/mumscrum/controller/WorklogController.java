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
		
		request.getSession().setAttribute("userStoryId", request.getParameter("userStoryId"));
		int userStoryId = Integer.valueOf(request.getParameter("userStoryId"));
		String userStoryName = userstoryService.getUserStoryById(userStoryId).getName();
		model.addAttribute("title", userStoryName);
		model.addAttribute("userStoryId", userStoryId);
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
		
		//get user information
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		
		//get user story information
		request.getSession().setAttribute("userStoryId", request.getParameter("userStoryId"));
		int userStoryId = Integer.valueOf(request.getParameter("userStoryId"));
		String userStoryName = userstoryService.getUserStoryById(userStoryId).getName();
		model.addAttribute("subtitle", userStoryName);
		
		if(request.getParameter("worklogId")!=null) { //select of existing worklog to update
			model.addAttribute("worklog", worklogService.getWorklogById(Integer.valueOf(request.getParameter("worklogId"))));
			request.getSession().setAttribute("worklogId", request.getParameter("worklogId"));
			model.addAttribute("title", "Edit Worklog");
		}
		else {
			model.addAttribute("title", "Add New Worklog");
			request.getSession().setAttribute("worklogId", "-1"); //create new worklog
		}
		model.addAttribute("worklogBean", new WorklogBean()); //for commandName="worklogBean" on worklogForm.jsp
		//model.addAttribute("userStoryId",request.getParameter("userStoryId"));
		return "worklog/worklogForm";
	}
	
	@RequestMapping(value = "/worklogForm", method = RequestMethod.POST)
	public String createWorklogPost(@Valid @ModelAttribute("worklogBean") WorklogBean worklogModel,
			BindingResult result, HttpServletRequest request, Model model) {
		
		LOGGER.info("worklog/worklogForm - Method = POST");
		
			
			if(result.hasErrors()){
				
				if(!request.getSession().getAttribute("worklogId").equals("-1")) {
					model.addAttribute("title", "Edit Worklog");
				}
				else{
					model.addAttribute("title", "Add New Worklog");
				}
				int userStoryId = Integer.valueOf(request.getSession().getAttribute("userStoryId").toString());
				String userStoryName = userstoryService.getUserStoryById(userStoryId).getName();
				model.addAttribute("subtitle", userStoryName);
				
				Employee emp = (Employee) request.getSession().getAttribute("login_id");
				model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
				model.addAttribute("role", emp.getRole().getName());
				return "worklog/worklogForm";
			}
			else{
				
				Worklog worklog = new Worklog();
				UserStory userstory = new UserStory();
				userstory.setId(Integer.valueOf(request.getSession().getAttribute("userStoryId").toString()));
				worklog.setUserstory(userstory);
				worklog.setActualEffort(worklogModel.getActualEffort());
				worklog.setModifiedDate(worklogModel.getModifiedDate());
				worklog.setEffortType(worklogModel.getEffortType());
				
				if(!request.getSession().getAttribute("worklogId").equals("-1")) {
					worklog.setId(Integer.valueOf(request.getSession().getAttribute("worklogId").toString()));
					worklogService.updateWorklog(worklog);			
				}
				else {
					worklogService.createWorklog(worklog);
				}
				String url = "redirect:/worklog/worklogList?userStoryId=" + request.getSession().getAttribute("userStoryId").toString();
				request.getSession().removeAttribute("userStoryId");
				return url ;
			}
			

	}
	
	@RequestMapping(value = "/worklogDelete", method = RequestMethod.GET)
	public String deleteWorklog(Model model, HttpServletRequest request) {
		LOGGER.info("deleteWorklog - Method");
		int worklogId = Integer.valueOf(request.getParameter("worklogId"));
		worklogService.deleteWorklog(worklogId);
		
		String url = "redirect:/worklog/worklogList?userStoryId=" + request.getSession().getAttribute("userStoryId").toString();
		request.getSession().removeAttribute("userStoryId");
		return url;
	}
}
