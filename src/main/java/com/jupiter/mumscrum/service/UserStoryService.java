package com.jupiter.mumscrum.service;

import java.util.List;

import com.jupiter.mumscrum.entity.UserStory;

public interface UserStoryService {
	
	public void createProduct(UserStory userStory);
	public List<UserStory> userStoryList();
}
