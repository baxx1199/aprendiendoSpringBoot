package com.baxxy.springboot.horario.app.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura ;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	
	@GetMapping({"", "/", "/index"})
	public String index(Model model) {
		model.addAttribute("title", "Horario atencion");
		return "index";
	}
	
	
	@GetMapping("/cerrado")
	public String cerrado(Model model) {
		StringBuilder mensaje = new StringBuilder("¿¿ Hola ?? ¿Hay alguien Por aca?.....");
		mensaje.append("Upp creo que hemos llegado tarde. ");
		mensaje.append(" Por favor visitanos en el horario " + apertura);
		mensaje.append(":00 hrs y las " + cierre +":00 hrs. ");
		mensaje.append("Mientras relajate toma un tour por nuestra pagina, *ZZZZZ*");
		model.addAttribute("title", "upps Volevemos pronto");
		model.addAttribute("horario", mensaje);
		return "cerrado";
	}

}
