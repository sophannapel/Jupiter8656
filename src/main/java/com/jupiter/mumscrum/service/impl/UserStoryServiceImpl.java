package com.jupiter.mumscrum.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.dataaccess.UserStoryDAO;
import com.jupiter.mumscrum.entity.UserStory;
import com.jupiter.mumscrum.service.UserStoryService;

@Service
public class UserStoryServiceImpl implements UserStoryService {
	
	@Autowired
	private UserStoryDAO userStoryDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryServiceImpl.class);

	@Override
	public void createUserStory(UserStory userStory) {
		LOGGER.info("Create user story : " + userStory.getId());
		userStoryDao.createUserStory(userStory);
	}

	@Override
	public List<UserStory> userStoryList() {
		return userStoryDao.userStoryList();
	}

	@Override
	public UserStory getUserStoryById(int id) {
		return userStoryDao.getUserStoryById(id);
	}

	@Override
	public void updateUserStory(UserStory userStory) {
		userStoryDao.updateUserStory(userStory);
	}

	@Override
	public void deleteUserStory(int id) {
		userStoryDao.deleteUserStory(id);
	}

	
}
