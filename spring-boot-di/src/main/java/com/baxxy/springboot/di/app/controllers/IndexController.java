package com.baxxy.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.baxxy.springboot.di.app.models.services.IService;

@Controller
public class IndexController {
	
	@Autowired
	@Qualifier ("myComplicateService")
	private IService service;
	
	/*
	@Autowired
	public IndexController(IService service) {

		this.service = service;
	}
	*/


	@GetMapping({"/","","index"})
	public String index(Model model) {
		model.addAttribute("objeto",service.operation());
		return "index";
	}
	
	/*
	@Autowired
	public void setService(IService service) {
		this.service = service;
	}*/
}
