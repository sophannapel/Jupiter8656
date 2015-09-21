package com.jupiter.mumscrum.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.*;
import java.util.Date;


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

	private double actualEffort;

	private Date modifiedDate;
	
	private String effortType;
	
	// bi-directional many-to-one association to User story
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name = "userStoryId")
	private UserStory userstory;

	public Worklog() {
	}
	
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEffortType() {
		return effortType;
	}

	public void setEffortType(String effortType) {
		this.effortType = effortType;
	}

	public double getActualEffort() {
		return this.actualEffort;
	}

	public void setActualEffort(double actualEffort) {
		this.actualEffort = actualEffort;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public UserStory getUserstory() {
		return this.userstory;
	}

	public void setUserstory(UserStory userstory) {
		this.userstory = userstory;
	}
	
	public String formatModifiedDate() {
		if(modifiedDate != null)return new SimpleDateFormat("yyyy-MM-dd").format(modifiedDate);
		else return "N/A";
	}

}