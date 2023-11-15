package com.baxxy.springboot.form.app.models.domain;



public class Pais {
	
	
	private String code;
	private String name;

	public Pais() {

	}

	public Pais(String code, String name) {

		this.code = code;
		this.name = name;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		
		return this.code;
	}
}
