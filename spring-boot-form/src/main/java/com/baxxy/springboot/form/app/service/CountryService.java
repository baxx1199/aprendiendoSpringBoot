package com.baxxy.springboot.form.app.service;

import java.util.List;

import com.baxxy.springboot.form.app.models.domain.Pais;

public interface CountryService {
	public List<Pais> initial_List();
	
	public Pais GetByCode(String code);
}
