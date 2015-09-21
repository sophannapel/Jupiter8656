package com.jupiter.mumscrum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.entity.UserStory;


public interface ReleaseBacklogService {
	public List<ReleaseBacklog> listRelease();
	public List<ReleaseBacklog> listReleaseByProductId(int productId);
	public void createRelease(ReleaseBacklog release);
	public ReleaseBacklog getReleaseBacklogById(int releaseId);
	public void updateReleaseBacklog(ReleaseBacklog releaseBacklog);
	public void deleteReleaseBacklog(int id);
}
