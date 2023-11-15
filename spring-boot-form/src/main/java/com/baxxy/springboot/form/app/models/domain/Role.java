package com.baxxy.springboot.form.app.models.domain;

public class Role {

	private Integer id;
	private String nameRole;
	private String typeRole;

	public Role() {

	}

	public Role(Integer id, String typeRole, String nameRole) {
		super();
		this.id = id;
		this.nameRole = nameRole;
		this.typeRole = typeRole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public String getTypeRole() {
		return typeRole;
	}

	public void setTypeRole(String typeRole) {
		this.typeRole = typeRole;
	}
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		
		if(!(obj instanceof Role)) {
			return true;
		}
		
		Role role = (Role)obj;
		return this.id != null  && this.id.equals(role.getId());
	}

}
