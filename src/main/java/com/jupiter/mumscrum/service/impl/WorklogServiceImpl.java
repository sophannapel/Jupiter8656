package com.jupiter.mumscrum.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.dataaccess.WorklogDAO;
import com.jupiter.mumscrum.entity.Worklog;
import com.jupiter.mumscrum.service.WorklogService;

@Service
public class WorklogServiceImpl implements WorklogService {

	@Autowired
	private WorklogDAO worklogDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(WorklogServiceImpl.class);
	
	@Override
	public void createWorklog(Worklog worklog) {
		LOGGER.info("Create user story : " + worklog);
		worklogDao.createWorklog(worklog);
		
	}

	@Override
	public List<Worklog> worklogList(int userStoryId) {
		return worklogDao.worklogList(userStoryId);
	}

	@Override
	public Worklog getWorklogById(int worklogId) {
		return worklogDao.getWorklogById(worklogId);
	}

	@Override
	public void updateWorklog(Worklog worklog) {
		worklogDao.updateWorklog(worklog);
		
	}

	@Override
	public void deleteWorklog(int worklogId) {
		worklogDao.deleteWorklog(worklogId);
		
	}

}
