package com.jupiter.mumscrum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jupiter.mumscrum.service.UserStoryService;

@Controller
@RequestMapping(value="/userStory")
public class UserStoryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryController.class);
	
	@Autowired
	UserStoryService userStoryService;
	
	@RequestMapping(value = "/userStoryList", method = RequestMethod.GET)
	public String ListUserStory(Model model) {
		LOGGER.info("ListUserStory - Method = GET");
		model.addAttribute("userStoryList", userStoryService.userStoryList());
		return "userStory/userStoryList";
	}
	
	@RequestMapping(value = "/userStoryForm", method = RequestMethod.POST)
	public String createUserStory() {
		return null;
	}
}
