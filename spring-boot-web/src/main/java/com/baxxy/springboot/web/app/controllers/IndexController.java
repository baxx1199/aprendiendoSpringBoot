package com.baxxy.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baxxy.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app") // this mapping serves us for add a general path or root path for the handler
						// methods
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String txtindex;

	/*
	 * this is a handler method that serves us for the administration of paths.
	 */
	@GetMapping({ "/index", "/", "/home" }) // this method is a short version of method RequestMapping(value="",
											// method=typeMethod)
	public String index(Model model) { // other options we are available are: ModelMap model or using map from
										// java.util this would be so Map<String, Object> map and the implementation
										// map.put(nameAttr, valueAttr);
										// other option is the implementation of ModelAndView mv and we set the
										// attributes this would be mv.addObject(nameAttr, valueAttr); and
										// mv.setView(name of view); the return will be the view
		model.addAttribute("titulo", txtindex);
		return "index";
	}

	@GetMapping("/profile")
	public String profile(Model model) {

		Usuario user = new Usuario();
		user.setName("Baxx");
		user.setLastname("baxter");
		user.setEmail("baxxb@correo.com");

		model.addAttribute("titulo", "Perfil de ".concat(user.getName()));
		model.addAttribute("user", user);

		return "profile";
	}

	@GetMapping("/users")
	public String listar(Model model) {
		List<Usuario> users = new ArrayList<Usuario>();

		// adding items from users array
		users.add(new Usuario("jason", "Todd", "redHodd@batfamily.com"));
		users.add(new Usuario("julian", "cobos", null));
		users.add(new Usuario("clark", "kent", "superman@jl.org"));
		users.add(new Usuario("Bruce", "wayne", "batman@jl.org"));
		users.add(new Usuario("ethan", "mayors", null));
		
		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("users", users);
		return "userslist";

	}
	/*	
	 *  Using modelAttribute would be like this
	@GetMapping("/users")
	public String listar(Model model) {

		
		model.addAttribute("titulo", "Listado de Usuarios");

		return "userslist";

	}

	@ModelAttribute("users") //With ModelAttribute() we can share data between views.This data will be available for all views
	public List<Usuario> fillUsers() {
		List<Usuario> users = new ArrayList<Usuario>();

		// adding items from users array
		users.add(new Usuario("jason", "Todd", "redHodd@batfamily.com"));
		users.add(new Usuario("julian", "cobos", null));
		users.add(new Usuario("clark", "kent", "superman@jl.org"));
		users.add(new Usuario("Bruce", "wayne", "batman@jl.org"));
		users.add(new Usuario("ethan", "mayors", null));

		return users;
	}
*/
}
