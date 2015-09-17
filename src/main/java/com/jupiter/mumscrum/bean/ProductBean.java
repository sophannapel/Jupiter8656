package com.jupiter.mumscrum.bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class ProductBean {

	//private int id;
	
	@NotEmpty(message = "Enter product name")
	private String name;
	
	//@NotBlank(message = "timesheet.cadastro.horainicio.obrigatorio")
	private Timestamp startDate;
	
	//@NotEmpty(message = "Enter due date")
	private Timestamp dueDate;
	
	private String description;
	
	//@NotNull(message = "Enter product status")
	private int statusId;

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

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

}
