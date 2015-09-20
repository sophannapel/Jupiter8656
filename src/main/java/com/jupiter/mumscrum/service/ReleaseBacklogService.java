package com.jupiter.mumscrum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.entity.ReleaseBacklog;


public interface ReleaseBacklogService {
	public List<ReleaseBacklog> listRelease();
}
