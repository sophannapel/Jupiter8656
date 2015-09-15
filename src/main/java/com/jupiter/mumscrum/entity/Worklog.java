package com.jupiter.mumscrum.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the worklog database table.
 * 
 */
@Entity
@NamedQuery(name="Worklog.findAll", query="SELECT w FROM Worklog w")
public class Worklog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int actualEffort;

	private Timestamp modifiedDate;

	//bi-directional many-to-one association to Userstory
	@ManyToOne
	@JoinColumn(name="userStoryId")
	private Userstory userstory;

	public Worklog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActualEffort() {
		return this.actualEffort;
	}

	public void setActualEffort(int actualEffort) {
		this.actualEffort = actualEffort;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Userstory getUserstory() {
		return this.userstory;
	}

	public void setUserstory(Userstory userstory) {
		this.userstory = userstory;
	}

}