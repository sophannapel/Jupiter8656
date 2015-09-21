package com.jupiter.mumscrum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.dataaccess.ReleaseBacklogDAO;
import com.jupiter.mumscrum.entity.ReleaseBacklog;
import com.jupiter.mumscrum.service.ReleaseBacklogService;

@Service
public class ReleaseBacklogServiceImpl implements ReleaseBacklogService{


	@Autowired
	private ReleaseBacklogDAO releaseDao;
	
	@Override
	public List<ReleaseBacklog> listRelease() {
		return releaseDao.listRelease();
	}

	@Override
	public List<ReleaseBacklog> listReleaseByProductId(int productId) {
		return null;
	}

	@Override
	public void createRelease(ReleaseBacklog release) {
		releaseDao.createRelease(release);
	}

	@Override
	public ReleaseBacklog getReleaseBacklogById(int releaseId) {
		return releaseDao.getReleaseBacklogById(releaseId);
	}

	@Override
	public void updateReleaseBacklog(ReleaseBacklog releaseBacklog) {
		releaseDao.updateReleaseBacklog(releaseBacklog);
	}

	@Override
	public void deleteReleaseBacklog(int id) {
		releaseDao.deleteReleaseBacklog(id);
	}

	
}
