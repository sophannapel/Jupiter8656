package com.jupiter.mumscrum.dataaccess;

import java.util.List;

import com.jupiter.mumscrum.entity.Coordinates;
import com.jupiter.mumscrum.entity.Sprint;

public interface SprintDAO {
	
	public int insertSprint(Sprint sprint);
	public List<Sprint> listSprint();
	public Sprint getSprintById(int id); 
	public void updateSprint(Sprint sprint);
	public void deleteSprint(int id);
	public List<Sprint> getSprintsByReleaseId(int releaseId);
	public Long getTotalEstimate(int id);
	public List<Coordinates>  getWorklogDataSet(int id);
}
