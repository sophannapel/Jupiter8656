package com.jupiter.mumscrum.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

//The use of (cascade=CascadeType.ALL) is when product is gone, the association data such as user story, release, and 
//sprint also gone.
/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private Date dueDate;

	private String name;

	private Date startDate;
	
	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employeeId;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="statusId")
	private Status status;

	//bi-directional many-to-one association to ReleaseBacklog
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<ReleaseBacklog> releaseBacklogs;

	//bi-directional many-to-one association to Userstory
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<UserStory> userstories;

	public Product() {
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


	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ReleaseBacklog> getReleaseBacklogs() {
		return this.releaseBacklogs;
	}

	public void setReleaseBacklogs(List<ReleaseBacklog> releaseBacklogs) {
		this.releaseBacklogs = releaseBacklogs;
	}

	public ReleaseBacklog addReleaseBacklog(ReleaseBacklog releaseBacklog) {
		getReleaseBacklogs().add(releaseBacklog);
		releaseBacklog.setProduct(this);

		return releaseBacklog;
	}

	public ReleaseBacklog removeReleaseBacklog(ReleaseBacklog releaseBacklog) {
		getReleaseBacklogs().remove(releaseBacklog);
		releaseBacklog.setProduct(null);

		return releaseBacklog;
	}

	public List<UserStory> getUserstories() {
		return this.userstories;
	}

	public void setUserstories(List<UserStory> userstories) {
		this.userstories = userstories;
	}

	public UserStory addUserstory(UserStory userstory) {
		getUserstories().add(userstory);
		userstory.setProduct(this);

		return userstory;
	}

	public UserStory removeUserstory(UserStory userstory) {
		getUserstories().remove(userstory);
		userstory.setProduct(null);

		return userstory;
	}

}