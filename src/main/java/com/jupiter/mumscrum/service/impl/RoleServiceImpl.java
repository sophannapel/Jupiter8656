package com.jupiter.mumscrum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.mumscrum.dataaccess.RoleDAO;
import com.jupiter.mumscrum.entity.Role;
import com.jupiter.mumscrum.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDAO roleDao;
	
	@Override
	public Role getRole(int roleId) {
		return roleDao.getRole(roleId);
	}

}
