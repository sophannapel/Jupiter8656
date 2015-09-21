package com.jupiter.mumscrum.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jupiter.mumscrum.bean.SprintBean;
import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.entity.Sprint;
import com.jupiter.mumscrum.service.ProductService;
import com.jupiter.mumscrum.service.ReleaseBacklogService;
import com.jupiter.mumscrum.service.SprintService;
import com.jupiter.mumscrum.util.Utility;

@Controller
public class SprintController {

	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReleaseBacklogService releaseBacklogService; 
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SprintController.class);

	
	@RequestMapping(value = "sprint/sprintForm", method = RequestMethod.GET)
	public String sprintPage(Model model) {
		
		LOGGER.info("Get Method for createSprint");
		model.addAttribute("productList",  productService.listProduct());
		return "sprint/sprintForm";
	}

	
	@RequestMapping(value = "sprint/createSprint", method = RequestMethod.POST)
	public String insertSprint(@ModelAttribute("sprintBean") SprintBean sprintBean) {

		LOGGER.info("Scrum Master saves new Sprint information");

		Sprint sprint = new Sprint();
		sprint.setName(sprintBean.getName());
		sprint.setStartDate(sprintBean.getStartDate());
		sprint.setDueDate(sprintBean.getDueDate());
		ReleaseBacklog release = new ReleaseBacklog(); 
		release.setId(sprintBean.getReleaseId());
		sprint.setReleaseBacklog(release);
		
		sprintService.insertSprint(sprint);

		return "redirect:/sprint/sprintForm";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "sprint/getProductReleases")
	@ResponseBody
	public String handleRequest( @RequestParam("productId") int id)  {
		List<ReleaseBacklog> releases = releaseBacklogService.listRelease();
		List<ReleaseBacklog> productRelease = new ArrayList<ReleaseBacklog>(); 
		
		for(ReleaseBacklog release: releases){
			if(release.getProduct().getId() == id){
				productRelease.add(release);
			}
		}

		String json =  Utility.generateJSON(productRelease);
		return json;

	}

	@RequestMapping(value = "sprint/sprintList", method = RequestMethod.GET)
	public String sprintList(Model model) {
		
		LOGGER.info("Get Method for sprintList");
		model.addAttribute("sprintList",  sprintService.listSprint());
		return "sprint/sprintList";
	}
	
	@RequestMapping(value = "sprint/editSprint", method = RequestMethod.GET)
	public String editSprint(@RequestParam("id") int id ,Model model) {
		
		LOGGER.info("Edit method for Sprint id:: "+ id);
		model.addAttribute("sprint",  sprintService.getSprintById(id));
		model.addAttribute("productList",  productService.listProduct());
		return "sprint/sprintUpdate";
	}
	
	@RequestMapping(value = "sprint/updateSprint", method = RequestMethod.POST)
	public String updateSprint(@ModelAttribute("sprintBean") SprintBean sprintBean) {

		LOGGER.info("Updates data for Sprint ::" + sprintBean.getId());				
		Sprint sprint = new Sprint();
		sprint.setId(sprintBean.getId());
		sprint.setName(sprintBean.getName());
		sprint.setStartDate(sprintBean.getStartDate());
		sprint.setDueDate(sprintBean.getDueDate());
		ReleaseBacklog release = new ReleaseBacklog(); 
		release.setId(sprintBean.getReleaseId());
		sprint.setReleaseBacklog(release);
				
		sprintService.updateSprint(sprint);

		return "redirect:/sprint/sprintList";
	}

	@RequestMapping(value = "sprint/deleteSprint", method = RequestMethod.GET)
	public String deleteSprint(@RequestParam("id") int id ,Model model) {
		
		LOGGER.info("Delete method for Sprint id:: "+ id);
		sprintService.deleteSprint(id);
		return "redirect:/sprint/sprintList";
	}
}