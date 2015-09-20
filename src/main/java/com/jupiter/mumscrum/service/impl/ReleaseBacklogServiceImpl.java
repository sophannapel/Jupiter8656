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

	
}
