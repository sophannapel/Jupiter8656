package com.jupiter.mumscrum.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the userstory database table.
 * 
 */
@Entity
@NamedQuery(name="Userstory.findAll", query="SELECT u FROM UserStory u")
public class UserStory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
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

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;

	//bi-directional many-to-one association to Worklog
	@OneToMany(mappedBy="userstory")
	private List<Worklog> worklogs;

	public UserStory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDeveloperId() {
		return this.developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public Timestamp getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public int getEstimateDevEffort() {
		return this.estimateDevEffort;
	}

	public void setEstimateDevEffort(int estimateDevEffort) {
		this.estimateDevEffort = estimateDevEffort;
	}

	public int getEstimateTestEffort() {
		return this.estimateTestEffort;
	}

	public void setEstimateTestEffort(int estimateTestEffort) {
		this.estimateTestEffort = estimateTestEffort;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getReleaseId() {
		return this.releaseId;
	}

	public void setReleaseId(int releaseId) {
		this.releaseId = releaseId;
	}

	public int getSprintId() {
		return this.sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Worklog> getWorklogs() {
		return this.worklogs;
	}

	public void setWorklogs(List<Worklog> worklogs) {
		this.worklogs = worklogs;
	}

	public Worklog addWorklog(Worklog worklog) {
		getWorklogs().add(worklog);
		worklog.setUserstory(this);

		return worklog;
	}

	public Worklog removeWorklog(Worklog worklog) {
		getWorklogs().remove(worklog);
		worklog.setUserstory(null);

		return worklog;
	}

}