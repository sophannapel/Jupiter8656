package com.jupiter.mumscrum.service;

import java.util.List;

import com.jupiter.mumscrum.entity.Worklog;

public interface WorklogService {
	public void createWorklog(Worklog worklog);
	public List<Worklog> worklogList(int userStoryId);
	public Worklog getWorklogById(int worklogId);
	public void updateWorklog(Worklog worklog);
	public void deleteWorklog(int worklogId);
}
