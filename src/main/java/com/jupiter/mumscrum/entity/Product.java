package com.jupiter.mumscrum.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private Timestamp startDate;
	private Timestamp dueDate;
	private String description;
	private int statusId;
	private int employeeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getDueDate() {
		return dueDate;
	}
	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
/*
	@Lob
	private String description;

	private Timestamp dueDate;

	private int employeeId;

	private String name;

	private Timestamp startDate;

	//bi-directional many-to-one association to Status
	@ManyToOne
	//@JoinColumn(name="statusId")
	//private Status status;
	private int status;

	//bi-directional many-to-one association to ReleaseBacklog
	@OneToMany(mappedBy="product")
	private List<ReleaseBacklog> releaseBacklogs;

	//bi-directional many-to-one association to Userstory
	@OneToMany(mappedBy="product")
	private List<Userstory> userstories;

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

	public Timestamp getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	/*public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
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

	public List<Userstory> getUserstories() {
		return this.userstories;
	}

	public void setUserstories(List<Userstory> userstories) {
		this.userstories = userstories;
	}

	public Userstory addUserstory(Userstory userstory) {
		getUserstories().add(userstory);
		userstory.setProduct(this);

		return userstory;
	}

	public Userstory removeUserstory(Userstory userstory) {
		getUserstories().remove(userstory);
		userstory.setProduct(null);

		return userstory;
	}
*/
}