package com.baxxy.springboot.error.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.baxxy.springboot.error.app.errors.UserNoFoundException;
import com.baxxy.springboot.error.app.models.User;
import com.baxxy.springboot.error.app.service.UserServiceImplement;

@Controller
public class AppController {
	
	@Autowired
	private UserServiceImplement usi;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("tt", "holi");
		return "index";
	}
	
	
	@GetMapping("/home")
	public String home(Model model) {
		//Integer v = Integer.parseInt("vale1");
		Integer v = 1/0;
		return "home";
	}
	
	@SuppressWarnings("null")
	@GetMapping("/user/{id}")
	public String seeUser(@PathVariable Integer id, Model model) {
		
		/*User user_to_See = usi.search(id);
		
		if(user_to_See == null) {
			throw new UserNoFoundException(id.toString());
		}*/
		
		User user_to_See = usi.searchWithOptional(id).orElseThrow(()-> new UserNoFoundException(id.toString()));
		
		
		model.addAttribute("user", user_to_See);
		model.addAttribute("title", "Datos del usuario: ".concat(user_to_See.getName()));
		
		return "user";
	}
}
