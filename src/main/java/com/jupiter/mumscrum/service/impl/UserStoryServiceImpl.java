package com.jupiter.mumscrum.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jupiter.mumscrum.dataaccess.UserStoryDAO;
import com.jupiter.mumscrum.entity.UserStory;
import com.jupiter.mumscrum.service.UserStoryService;

public class UserStoryServiceImpl implements UserStoryService {
	
	@Autowired
	private UserStoryDAO userStoryDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryServiceImpl.class);

	@Override
	public void createProduct(UserStory userStory) {
		LOGGER.info("Create user story : " + userStory);
		userStoryDao.createUserStory(userStory);
	}

	@Override
	public List<UserStory> userStoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
