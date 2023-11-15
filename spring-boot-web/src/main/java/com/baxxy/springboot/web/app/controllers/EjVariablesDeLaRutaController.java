package com.baxxy.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rutas")
public class EjVariablesDeLaRutaController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviando parametros entre rutas con '@PathVariable'");
		return "variables/index";
	}
	@GetMapping("/string/{textoruta}")
	public String variables(@PathVariable String textoruta, Model model) {
		
		model.addAttribute("titulo","Recibiendo parametros con '@PathVarible'");
		model.addAttribute("request", "El texto enviado con '@PathVariable' es: "+ textoruta);
		model.addAttribute("num1", Integer.parseInt("11"));
		
		return "variables/watchparams";
	}
	@GetMapping("/string/{textoruta}/{num}")
	public String variables(@PathVariable String textoruta, @PathVariable Integer num, Model model) {
		
		model.addAttribute("titulo","Recibiendo parametros con '@PathVarible'");
		model.addAttribute("request", "El texto enviado con '@PathVariable' es: '"+ textoruta+ "' y el numero enviado es: '"+ num + "'");
		return "variables/watchparams";
	}
	
}
