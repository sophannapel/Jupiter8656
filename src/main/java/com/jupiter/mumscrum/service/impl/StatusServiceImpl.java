package com.jupiter.mumscrum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.dataaccess.StatusDAO;
import com.jupiter.mumscrum.entity.Status;
import com.jupiter.mumscrum.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
		
	@Autowired
	private StatusDAO statusDao;
	
	@Override
	public List<Status> statusList() {
		return statusDao.statusList();
	}

}
