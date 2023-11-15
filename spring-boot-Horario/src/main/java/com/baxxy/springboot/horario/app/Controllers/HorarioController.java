package com.baxxy.springboot.horario.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HorarioController {
	
	@GetMapping("/home")
	public String index(Model model) {
		model.addAttribute("titulo", "Este es el titulo");
		return "index";
	}

}
