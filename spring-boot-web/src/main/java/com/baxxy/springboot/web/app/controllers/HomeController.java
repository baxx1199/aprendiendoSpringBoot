package com.baxxy.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/" , "/home"})
	public String home() {
		return"redirect:/app/index";
	}
	/*
	 * Redirect allow us, to redirect to a specific view changing the URL
	 * Forward allow us to redirect to a specific view without changing the URL; It works with local, not external, routes
	 * */
}
