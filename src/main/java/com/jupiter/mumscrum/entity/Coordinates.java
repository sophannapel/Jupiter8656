package com.jupiter.mumscrum.entity;

public class Coordinates {
	
	private int workHours;
	private String day;
	
	public Coordinates(int workHours, String day) {
		super();
		this.workHours = workHours;
		this.day = day;
	}
	public int getWorkHours() {
		return workHours;
	}
	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	

	
	
}
