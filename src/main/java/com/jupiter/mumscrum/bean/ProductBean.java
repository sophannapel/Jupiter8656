package com.jupiter.mumscrum.bean;

import java.sql.Timestamp;

public class ProductBean {

	
		private int id;
		private String description;
		private Timestamp dueDate;
		private int employeeId;
		private String name;
		private Timestamp startDate;
		private int status;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Timestamp getDueDate() {
			return dueDate;
		}
		public void setDueDate(Timestamp dueDate) {
			this.dueDate = dueDate;
		}
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
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
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}

	
}
