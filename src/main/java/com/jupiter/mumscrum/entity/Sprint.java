package com.jupiter.mumscrum.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.*;
import java.util.Date;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Date dueDate;

	private String name;

	private Date startDate;

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
	
	public String formatStartDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(startDate);
	}
	
	public String formatDueDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(dueDate);
	}

}