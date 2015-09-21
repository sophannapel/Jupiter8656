package com.jupiter.mumscrum.entity;

import java.io.Serializable;
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
 * The persistent class for the releaseBacklog database table.
 * 
 */
@Entity
@NamedQuery(name="ReleaseBacklog.findAll", query="SELECT r FROM ReleaseBacklog r")
public class ReleaseBacklog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descriptioon;

	private Date dueDate;

	private String name;

	private Date startDate;

	private String type;

	//bi-directional many-to-one association to Product
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productId")
	private Product product;

	//bi-directional many-to-one association to Sprint
	@OneToMany(mappedBy="releaseBacklog", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)  //when release is gone, sprint should be gone too
	private List<Sprint> sprints;

	//bi-directional many-to-one association to Userstory
	@OneToMany(mappedBy="releaseBacklog")
	private List<UserStory> userstories;
	
	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="scrumMasterId")
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ReleaseBacklog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescriptioon() {
		return this.descriptioon;
	}

	public void setDescriptioon(String descriptioon) {
		this.descriptioon = descriptioon;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Sprint> getSprints() {
		return this.sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

	public Sprint addSprint(Sprint sprint) {
		getSprints().add(sprint);
		sprint.setReleaseBacklog(this);

		return sprint;
	}

	public Sprint removeSprint(Sprint sprint) {
		getSprints().remove(sprint);
		sprint.setReleaseBacklog(null);

		return sprint;
	}

	public List<UserStory> getUserstories() {
		return this.userstories;
	}

	public void setUserstories(List<UserStory> userstories) {
		this.userstories = userstories;
	}

	public UserStory addUserstory(UserStory userstory) {
		getUserstories().add(userstory);
		userstory.setReleaseBacklog(this);

		return userstory;
	}

	public UserStory removeUserstory(UserStory userstory) {
		getUserstories().remove(userstory);
		userstory.setReleaseBacklog(null);
		return userstory;
	}

	public String formatStartDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(startDate);
	}
	
	public String formatDueDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(dueDate);
	}
}