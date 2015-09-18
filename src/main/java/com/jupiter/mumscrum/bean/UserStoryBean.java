package com.jupiter.mumscrum.bean;

import java.sql.Timestamp;

import com.jupiter.mumscrum.entity.Product;

public class UserStoryBean {

	//NEED TO ADD VALIDATION
	private int id;

	private String description;

	private int developerId;

	private Timestamp dueDate;

	private int estimateDevEffort;

	private int estimateTestEffort;

	private String name;

	private int ownerId;

	private String priority;

	private int releaseId;

	private int sprintId;

	private Timestamp startDate;

	private int testId;
	
	//private Product product;
	
	private int productId;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public int getEstimateDevEffort() {
		return estimateDevEffort;
	}

	public void setEstimateDevEffort(int estimateDevEffort) {
		this.estimateDevEffort = estimateDevEffort;
	}

	public int getEstimateTestEffort() {
		return estimateTestEffort;
	}

	public void setEstimateTestEffort(int estimateTestEffort) {
		this.estimateTestEffort = estimateTestEffort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(int releaseId) {
		this.releaseId = releaseId;
	}

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}
	
	
}
