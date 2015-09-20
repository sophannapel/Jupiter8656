package com.jupiter.mumscrum.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
		model.addAttribute("releaseId", 1);
		model.addAttribute("productList",  productService.listProduct());
		model.addAttribute("releaseList", releaseBacklogService.listRelease());
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

		return "sprint/sprintForm";
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


}
