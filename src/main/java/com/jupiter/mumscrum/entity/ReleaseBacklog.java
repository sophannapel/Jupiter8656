package com.jupiter.mumscrum.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


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

	private Timestamp dueDate;

	private String name;

	private Timestamp startDate;

	private String type;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;

	//bi-directional many-to-one association to Sprint
	@OneToMany(mappedBy="releaseBacklog", cascade=CascadeType.ALL)  //when release is gone, sprint should be gone too
	private List<Sprint> sprints;

	//bi-directional many-to-one association to Userstory
	@OneToMany(mappedBy="releaseBacklog")
	private List<UserStory> userstories;

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

	public Timestamp getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
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

}