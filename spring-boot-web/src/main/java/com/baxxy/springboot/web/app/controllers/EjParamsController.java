package com.baxxy.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/params")
public class EjParamsController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="text",required=false, defaultValue="soy por defecto") String text, Model model) {
		
		model.addAttribute("request", "the text send has: "+ text);
		return "params/watchparams";
	}

	@GetMapping("/mix-params")
	public String param(@RequestParam String text, @RequestParam Integer num, Model model) {
		
		model.addAttribute("request", "the text send has: '"+ text + "' the num send has: '"+ num+ "'");
		return "params/watchparams";
	}
	
	/*
	 * another way to send many parameters is using HttpServletRequest
	 */
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String greeting = request.getParameter("greeting");
		Integer num = null;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		} catch (NumberFormatException e) {
			num=0;
		}
		
		model.addAttribute("request", "the text send has: '"+ greeting + "' the num send has: '"+ num+ "'");
		return "params/watchparams";
	}
	

}
