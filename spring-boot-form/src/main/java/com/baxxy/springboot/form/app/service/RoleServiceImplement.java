package com.baxxy.springboot.form.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baxxy.springboot.form.app.models.domain.Role;

@Service
public class RoleServiceImplement implements RoleService{
	public List<Role> rolesList = new ArrayList<>();
	
	public RoleServiceImplement() {
		this.rolesList.add(new Role(1, "ROLE_USER", "Usuario"));
		this.rolesList.add(new Role(2, "ROLE_ADMIN", "Administrador"));
		this.rolesList.add(new Role(3, "ROLE_MODERATOR", "Moderador"));
	}
	
	@Override
	public List<Role> initial_RolesList() {
		
		return rolesList;
	}

	@Override
	public Role getByCode(Integer id) {
		Role roleResult = null;
		for (Role role : rolesList) {
			if(id == role.getId()) {
				roleResult= role;
				break;
			}
			
		}
		
		return roleResult;
	}

	@Override
	public Role getByType(String typeRole) {
		Role roleResult = null;
		for (Role role : rolesList) {
			if(typeRole.equals(role.getTypeRole())) {
				roleResult= role;
				break;
			}
			
		}
		
		return roleResult;
	}

	@Override
	public Role getByName(String nameRole) {
		Role roleResult = null;
		for (Role role : rolesList) {
			if(nameRole.equals(role.getNameRole())) {
				roleResult= role;
				break;
			}
			
		}
		
		return roleResult;
	}

	
	
	
}
