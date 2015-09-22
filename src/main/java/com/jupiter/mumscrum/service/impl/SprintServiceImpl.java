package com.jupiter.mumscrum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.dataaccess.SprintDAO;
import com.jupiter.mumscrum.entity.Coordinates;
import com.jupiter.mumscrum.entity.Sprint;
import com.jupiter.mumscrum.service.SprintService;

@Service
public class SprintServiceImpl implements SprintService {

	@Autowired
	private SprintDAO sprintDAO;

	@Override
	public void insertSprint(Sprint sprint) {
		sprintDAO.insertSprint(sprint);
	}

	@Override
	public List<Sprint> listSprint() {		
		return sprintDAO.listSprint();
	}

	@Override
	public Sprint getSprintById(int id) {
		return sprintDAO.getSprintById(id);
	}

	@Override
	public void updateSprint(Sprint sprint) {
		sprintDAO.updateSprint(sprint);		
	}
	
	@Override
	public  void deleteSprint(int id){
		sprintDAO.deleteSprint(id);		
	}

	@Override
	public Long getTotalEstimate(int id) {
		return sprintDAO.getTotalEstimate(id);
	}

	@Override
	public List<Coordinates> getWorklogDataSet(int id) {
		return sprintDAO.getWorklogDataSet(id);
	}
	
}
