package com.jupiter.mumscrum.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the Employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String firstname;

	private String lastname;

	private String password;

	private String status;

	private String username;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role;

	//bi-directional many-to-one association to Userstory
	@OneToMany(mappedBy="ownerId")
	private List<UserStory> userstories1;

	//bi-directional many-to-one association to Userstory
	@OneToMany(mappedBy="testId")
	private List<UserStory> userstories2;

	//bi-directional many-to-one association to Userstory
	@OneToMany(mappedBy="developerId")
	private List<UserStory> userstories3;
	
	//bi-directional many-to-one association to ReleaseBacklog
	@OneToMany(mappedBy="employee")
	private List<ReleaseBacklog> releaseBacklogs;

	public List<ReleaseBacklog> getReleaseBacklogs() {
		return releaseBacklogs;
	}

	public void setReleaseBacklogs(List<ReleaseBacklog> releaseBacklogs) {
		this.releaseBacklogs = releaseBacklogs;
	}

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<UserStory> getUserstories1() {
		return this.userstories1;
	}

	public void setUserstories1(List<UserStory> userstories1) {
		this.userstories1 = userstories1;
	}

	public List<UserStory> getUserstories2() {
		return userstories2;
	}

	public void setUserstories2(List<UserStory> userstories2) {
		this.userstories2 = userstories2;
	}

	public List<UserStory> getUserstories3() {
		return userstories3;
	}

	public void setUserstories3(List<UserStory> userstories3) {
		this.userstories3 = userstories3;
	}

	public String getFullname() {
		return firstname+" "+lastname;
	}
	
}