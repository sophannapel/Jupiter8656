package com.jupiter.mumscrum.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the userstory database table.
 * 
 */
@Entity
@NamedQuery(name = "UserStory.findAll", query = "SELECT u FROM UserStory u")
public class UserStory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Date dueDate;
	private Date startDate;

	private int estimateDevEffort;

	private int estimateTestEffort;

	private String name;

	private String priority;

	private String description;

	// bi-directional many-to-one association to Product
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name = "productId")
	private Product product;

	// bi-directional many-to-one association to ReleaseBacklog
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name = "releaseId")
	private ReleaseBacklog releaseBacklog;

	// bi-directional many-to-one association to Sprint
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name = "sprintId")
	private Sprint sprint;

	// bi-directional many-to-one association to Worklog
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "userstory")
	private List<Worklog> worklogs;

	// bi-directional many-to-one association to Employee
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name = "ownerId")
	private Employee ownerId;

	// bi-directional many-to-one association to Employee
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name = "testId")
	private Employee testId;

	// bi-directional many-to-one association to Employee
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name = "developerId")
	private Employee developerId;

	public UserStory() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}



	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ReleaseBacklog getReleaseBacklog() {
		return this.releaseBacklog;
	}

	public void setReleaseBacklog(ReleaseBacklog releaseBacklog) {
		this.releaseBacklog = releaseBacklog;
	}

	public Sprint getSprint() {
		return this.sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
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

	public Employee getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Employee ownerId) {
		this.ownerId = ownerId;
	}

	public Employee getTestId() {
		return testId;
	}

	public void setTestId(Employee testId) {
		this.testId = testId;
	}

	public Employee getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(Employee developerId) {
		this.developerId = developerId;
	}
	
	@Override
	public String toString() {
		return "id = " +id+" dueDate = "+dueDate+" dev effort"+estimateDevEffort+" test effort = "+estimateTestEffort+" name = "+
				name+" priority = "+priority+" product = "+product.getId() + " release = "+releaseBacklog.getId()+ " sprint = "+sprint.getId()+" owner = "+ownerId.getId()+
				" devID = "+developerId.getId()+" testId = "+testId.getId();
	}
	
	public String formatStartDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(startDate);
	}
	
	public String formatDueDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(dueDate);
	}
}