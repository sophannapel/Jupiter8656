package com.jupiter.mumscrum.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class UserStoryBean {

	private int id;
	private String description;
	
	@NotNull
	@Column(nullable=false)
	private Integer developerId;

	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	
	@NotNull
	@Column(nullable=false)
	@Range(min=0)
	private Integer estimateDevEffort;
	
	@NotNull
	@Column(nullable=false)
	@Range(min=0)
	private Integer estimateTestEffort;
	
	@NotEmpty
	private String name;

	private Integer ownerId;
	
	@NotEmpty
	private String priority;
	
	@NotNull
	@Column(nullable=false)
	private Integer releaseId;

	@NotNull
	@Column(nullable=false)
	private Integer sprintId;

	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@NotNull
	@Column(nullable=false)
	private Integer testId;
	
	@NotNull
	@Column(nullable=false)
	private Integer productId;

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

	public Integer getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getEstimateDevEffort() {
		return estimateDevEffort;
	}

	public void setEstimateDevEffort(Integer estimateDevEffort) {
		this.estimateDevEffort = estimateDevEffort;
	}

	public Integer getEstimateTestEffort() {
		return estimateTestEffort;
	}

	public void setEstimateTestEffort(Integer estimateTestEffort) {
		this.estimateTestEffort = estimateTestEffort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(Integer releaseId) {
		this.releaseId = releaseId;
	}

	public Integer getSprintId() {
		return sprintId;
	}

	public void setSprintId(Integer sprintId) {
		this.sprintId = sprintId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "id="+id+" description="+description+" developerID="+developerId+" dueDate="+dueDate+
				" estimateDev="+estimateDevEffort+" estimateTest="+estimateTestEffort+" name="+name+" ownerId="+
				ownerId+" priority="+priority+" releaseID="+releaseId+"sprintID="+sprintId+" startDate="+
				startDate+" testId="+testId+" productID="+productId;
	}
}
