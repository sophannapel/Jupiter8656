package com.jupiter.mumscrum.dataaccess;

import java.util.List;

import com.jupiter.mumscrum.entity.ReleaseBacklog;


public interface ReleaseBacklogDAO {
	public List<ReleaseBacklog> listRelease();
	public List<ReleaseBacklog> listReleaseByProductId(int productId);
	public void createRelease(ReleaseBacklog release);
	public ReleaseBacklog getReleaseBacklogById(int releaseId);
	public void updateReleaseBacklog(ReleaseBacklog releaseBacklog);
	public void deleteReleaseBacklog(int id);
}
