package com.app.bean;

import java.util.List;

public class Student {
	
	private int id;
	private String name;
	private String course;
	
	private List<String> hobbies;
	public Student() {
		super();
	}
	
	
	
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



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public List<String> getHobbies() {
		return hobbies;
	}



	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + "]";
	}
	
	

}
