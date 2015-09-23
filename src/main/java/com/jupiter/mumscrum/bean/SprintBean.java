package com.jupiter.mumscrum.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class SprintBean {

	private int id;

	@NotEmpty
	private String name;
	
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	
	private Integer releaseId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(Integer releaseId) {
		this.releaseId = releaseId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}