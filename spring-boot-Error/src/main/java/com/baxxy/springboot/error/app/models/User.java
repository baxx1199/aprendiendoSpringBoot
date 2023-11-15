package com.baxxy.springboot.error.app.models;

public class User {
	private Integer id;
	private String name;
	private String job;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(Integer id,String name, String job ) {
		this.id= id;
		this.name = name;
		this.job = job;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
}
