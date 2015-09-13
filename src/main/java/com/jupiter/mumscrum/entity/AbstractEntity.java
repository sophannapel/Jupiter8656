package com.jupiter.mumscrum.entity;

public abstract class AbstractEntity {
	public String getId() {
		return getEntityPrimaryKey();
	}
	
	protected abstract String getEntityPrimaryKey();
}
