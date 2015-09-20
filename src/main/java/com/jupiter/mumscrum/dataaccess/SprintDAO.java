package com.jupiter.mumscrum.dataaccess;

import java.util.List;

import com.jupiter.mumscrum.entity.Sprint;

public interface SprintDAO {
	
	public void insertSprint(Sprint sprint);
	public List<Sprint> listSprint();
	public Sprint getSprintById(int id); 
	public void updateSprint(Sprint sprint);
}