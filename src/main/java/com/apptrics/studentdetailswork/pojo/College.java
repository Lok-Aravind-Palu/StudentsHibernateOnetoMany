package com.apptrics.studentdetailswork.pojo;

import java.util.Set;

public class College {
	
	private int id;
	private String collegeName;
	private Set<Students> student;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Students> getStudent() {
		return student;
	}
	public void setStudent(Set<Students> student) {
		this.student = student;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	

}
