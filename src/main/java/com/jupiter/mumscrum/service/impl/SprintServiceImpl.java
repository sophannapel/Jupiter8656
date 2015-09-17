package com.jupiter.mumscrum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.dataaccess.SprintDAO;
import com.jupiter.mumscrum.entity.Sprint;
import com.jupiter.mumscrum.service.SprintService;

@Service
public class SprintServiceImpl implements SprintService {

	@Autowired
	private SprintDAO sprintDAO;

	@Override
	public void insertSprint(Sprint sprintBean) {
		sprintDAO.insertSprint(sprintBean);
	}
}
