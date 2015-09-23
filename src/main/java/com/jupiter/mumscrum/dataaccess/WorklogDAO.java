package com.jupiter.mumscrum.dataaccess;

import java.util.List;

import com.jupiter.mumscrum.entity.UserStory;
import com.jupiter.mumscrum.entity.Worklog;

public interface WorklogDAO {
	
	public void createWorklog(Worklog worklog);
	public List<Worklog> worklogList(int userStoryId);
	public Worklog getWorklogById(int worklogId);
	public void updateWorklog(Worklog worklog);
	public void deleteWorklog(int worklogId);
	
}
