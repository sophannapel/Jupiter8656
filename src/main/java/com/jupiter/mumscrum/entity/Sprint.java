package com.jupiter.mumscrum.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the sprint database table.
 * 
 */
@Entity
@NamedQuery(name="Sprint.findAll", query="SELECT s FROM Sprint s")
public class Sprint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp dueDate;

	private String name;

	private Timestamp startDate;

	//bi-directional many-to-one association to ReleaseBacklog
	@ManyToOne
	@JoinColumn(name="releaseId")
	private ReleaseBacklog releaseBacklog;

	//bi-directional many-to-one association to Userstory
	@OneToMany(mappedBy="sprint")
	private List<UserStory> userstories;

	public Sprint() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public ReleaseBacklog getReleaseBacklog() {
		return this.releaseBacklog;
	}

	public void setReleaseBacklog(ReleaseBacklog releaseBacklog) {
		this.releaseBacklog = releaseBacklog;
	}

	public List<UserStory> getUserstories() {
		return this.userstories;
	}

	public void setUserstories(List<UserStory> userstories) {
		this.userstories = userstories;
	}

	public UserStory addUserstory(UserStory userstory) {
		getUserstories().add(userstory);
		userstory.setSprint(this);

		return userstory;
	}

	public UserStory removeUserstory(UserStory userstory) {
		getUserstories().remove(userstory);
		userstory.setSprint(null);

		return userstory;
	}

}