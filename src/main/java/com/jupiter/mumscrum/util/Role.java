package com.jupiter.mumscrum.util;

public enum Role {
	PRODUCT_OWNER(1),
	SCRUM_MASTER(2),
	DEVELOPER(3),
	TESTER(4),
	HR_ADMIN(5);
	
	private final int roleId;
	
	private Role(int roleId) {
		this.roleId = roleId;
	}
	
	public int getRoleId() {
		return roleId;
	}
}
