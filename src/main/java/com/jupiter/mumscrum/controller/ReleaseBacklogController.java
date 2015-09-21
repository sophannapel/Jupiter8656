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

import com.jupiter.mumscrum.bean.ReleaseBacklogBean;
import com.jupiter.mumscrum.entity.Employee;
import com.jupiter.mumscrum.entity.Product;
import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.service.ReleaseBacklogService;

@Controller
@RequestMapping(value = "/releaseBacklog")
public class ReleaseBacklogController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ReleaseBacklogService releaseBacklogService;
	
	@RequestMapping(value = "/releaseBacklogForm", method = RequestMethod.GET)
	public String createReleaseBacklogForm(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("login_id") != null) {
			model.addAttribute("releaseBacklogBean", new ReleaseBacklogBean());
			Employee emp = (Employee) request.getSession().getAttribute("login_id");
			model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
			model.addAttribute("role", emp.getRole().getName());
			model.addAttribute("title", "Add New Release Backlog");
			
			if(request.getParameter("releaseId")!=null) { //select of existing release backlog to update
				int releaseId = Integer.valueOf(request.getParameter("releaseId"));
				request.getSession().setAttribute("releaseId", releaseId);
				model.addAttribute("title", "Edit Release Backlog");
				model.addAttribute("releaseBacklog", releaseBacklogService.getReleaseBacklogById(releaseId));
			}
			else {
				request.getSession().setAttribute("releaseId", "-1"); //create new releaseBacklog
				model.addAttribute("title", "Add New Release Backlog");
			}
			return "releaseBacklog/releaseBacklogForm";
		} else
			return "redirect:/login";
	}
	
	@RequestMapping(value = "/releaseBacklogForm", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("releaseBacklogBean") ReleaseBacklogBean releaseBeanModel,
			BindingResult result, HttpServletRequest request) {

		LOGGER.info("ReleaseBacklog/ReleaseBacklogForm - Method = POST");
		if (result.hasErrors()) {
			return "releaseBacklog/releaseBacklogForm";
		} else {
			ReleaseBacklog newRelease = new ReleaseBacklog();
			Product product = new Product(); product.setId(releaseBeanModel.getProductId());
			Employee scrumMaster = new Employee(); scrumMaster.setId(releaseBeanModel.getScrumMasterId());
			newRelease.setDescriptioon(releaseBeanModel.getDescription());
			newRelease.setDueDate(releaseBeanModel.getDueDate());
			newRelease.setName(releaseBeanModel.getName());
			newRelease.setProduct(product);
			newRelease.setStartDate(releaseBeanModel.getStartDate());
			newRelease.setType(releaseBeanModel.getType());
			newRelease.setEmployee(scrumMaster);
			
			if(!request.getSession().getAttribute("releaseId").equals("-1")) {
				newRelease.setId(Integer.valueOf(request.getSession().getAttribute("releaseId").toString()));
				releaseBacklogService.updateReleaseBacklog(newRelease);
				request.getSession().removeAttribute("userStoryId");			
			}
			else {
				releaseBacklogService.createRelease(newRelease);
			}
			return "redirect:/releaseBacklog/releaseBacklogList";
		}
	}
	
	@RequestMapping(value = "/releaseBacklogList", method = RequestMethod.GET)
	public String listReleases(Model model, HttpServletRequest request) {
		model.addAttribute("releaseList", releaseBacklogService.listRelease());
		Employee emp = (Employee) request.getSession().getAttribute("login_id");
		model.addAttribute("username", emp.getFirstname() + " " + emp.getLastname());
		model.addAttribute("role", emp.getRole().getName());
		LOGGER.info("ReleaseBacklog/listReleases - Method = GET");
		return "releaseBacklog/releaseBacklogList";
	}
	
	@RequestMapping(value = "/releaseBacklogDelete", method = RequestMethod.GET)
	public String deleteReleaseBacklog(Model model, HttpServletRequest request) {
		LOGGER.info("deleteReleaseBacklog - Method");
		int releaseId = Integer.valueOf(request.getParameter("releaseId"));
		releaseBacklogService.deleteReleaseBacklog(releaseId);
		return "redirect:/releaseBacklog/releaseBacklogList";
	}
}
