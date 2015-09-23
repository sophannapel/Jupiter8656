package com.jupiter.mumscrum.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class ReleaseBacklogBean {
	
	@NotEmpty
	private String name;
	
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	
	private String description;
	
	@NotNull
	@Column(nullable=false)
	private Integer productId;
	
	@NotEmpty
	private String type;
	
	@NotNull
	@Column(nullable=false)
	private Integer scrumMasterId;

	public Integer getScrumMasterId() {
		return scrumMasterId;
	}

	public void setScrumMasterId(Integer scrumMasterId) {
		this.scrumMasterId = scrumMasterId;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}