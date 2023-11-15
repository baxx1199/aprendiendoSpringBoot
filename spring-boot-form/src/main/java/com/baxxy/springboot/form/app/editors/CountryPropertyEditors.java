package com.baxxy.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baxxy.springboot.form.app.service.CountryService;

@Component
public class CountryPropertyEditors extends PropertyEditorSupport {

	@Autowired
	private CountryService service;

	@Override
	public void setAsText(String code) throws IllegalArgumentException {
		if (code != null && code.length() > 0) {
			try {
				this.setValue(service.GetByCode(code));

			} catch (Exception e) {
				setValue(null);
			}
		} else {
			setValue(null);
		}

	}

}
