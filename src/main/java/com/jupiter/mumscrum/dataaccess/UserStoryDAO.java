package com.jupiter.mumscrum.dataaccess;

import java.util.List;

import com.jupiter.mumscrum.entity.UserStory;

public interface UserStoryDAO {
	
	public void createUserStory(UserStory userStory);
	public List<UserStory> userStoryList();
	public UserStory getUserStoryById(int id);
	public void updateUserStory(UserStory userStory);
	public void deleteUserStory(int id);
}
