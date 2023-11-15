package com.baxxy.springboot.form.app.service;

import java.util.List;

import com.baxxy.springboot.form.app.models.domain.Role;

public interface RoleService {

	public List<Role> initial_RolesList();
	
	public Role getByCode(Integer id);
	public Role getByType(String typeRole);
	public Role getByName(String nameRole);
}
