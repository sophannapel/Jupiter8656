package com.jupiter.mumscrum.service;

import java.util.List;

import com.jupiter.mumscrum.entity.UserStory;

public interface UserStoryService {
	
	public void createUserStory(UserStory userStory);
	public List<UserStory> userStoryList();
	public UserStory getUserStoryById(int id);
	public void updateUserStory(UserStory userStory);
}
