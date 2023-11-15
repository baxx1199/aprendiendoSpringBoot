package com.baxxy.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baxxy.springboot.form.app.service.RoleService;


@Component
public class RolesPropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		Integer id ;
		
		if (idString != null && idString.length() > 0) {
			id = Integer.parseInt(idString);
			
			try {
				this.setValue(roleService.getByCode(id));

			} catch (NumberFormatException e) {
				setValue(null);
			}
		} else {
			setValue(null);
		}
	}

}
