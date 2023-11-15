package com.baxxy.springboot.form.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baxxy.springboot.form.app.models.domain.Pais;

@Service
public class CountryServiceImplement implements CountryService {

	public List<Pais> Countrylist;
	
	public CountryServiceImplement() {
		this.Countrylist = Arrays.asList(
				new Pais("col", "Colombia"),
				new Pais("mex", "mexico"),
				new Pais("ve", "Venezuela"),
				new Pais("arg", "Argentina")
				);
	}
	
	@Override
	public List<Pais> initial_List() {
		
		return Countrylist;
	}

	@Override
	public Pais GetByCode(String code) {
		
		Pais countrie = null;
		
			for (Pais pais : Countrylist) {
				if(code.equals(pais.getCode())) {
					countrie= pais;
					break;
				}
			}
		
		return countrie;
	}

}
