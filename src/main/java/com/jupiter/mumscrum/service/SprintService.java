package com.jupiter.mumscrum.service;

import java.util.List;

import com.jupiter.mumscrum.entity.Sprint;

public interface SprintService {
	
	public void insertSprint(Sprint sprint);
	public List<Sprint> listSprint(); 
	public Sprint getSprintById(int id);
	public void updateSprint(Sprint sprint);
}