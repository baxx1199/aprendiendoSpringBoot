package com.baxxy.springboot.form.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.baxxy.springboot.form.app.editors.CountryPropertyEditors;
import com.baxxy.springboot.form.app.editors.FieldTextMayusEditor;
import com.baxxy.springboot.form.app.editors.RolesPropertyEditor;
import com.baxxy.springboot.form.app.models.domain.Pais;
import com.baxxy.springboot.form.app.models.domain.Role;
import com.baxxy.springboot.form.app.models.domain.User;
import com.baxxy.springboot.form.app.service.CountryService;
import com.baxxy.springboot.form.app.service.RoleService;
import com.baxxy.springboot.form.app.validators.UserValidation;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("user")
public class FormController {
	
	@Autowired
	private UserValidation uValidation;
	
	@Autowired
	private CountryService countryS;
	
	@Autowired
	private RoleService rolesS;
	
	@Autowired
	private CountryPropertyEditors countryEditor;
	
	@Autowired
	private RolesPropertyEditor roleEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(uValidation);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "username",new FieldTextMayusEditor());
		
		binder.registerCustomEditor(Pais.class,"country", countryEditor);
		binder.registerCustomEditor(Role.class, "roles", roleEditor);
		
		
	}
	@ModelAttribute("countrysList")
	public List<String> countrysList(){
		return Arrays.asList("Colombia","Argenitna","Perú","Venezuela","Noruega");
		
	}
	
	@ModelAttribute("countrysMap")
	public Map<String, String> countrysMap(){
		Map<String, String> countries= new HashMap<String, String>();
		
		countries.put("Col", "Colombia");
		countries.put("Arg", "Argentina");
		countries.put("Pe", "Perù");
		countries.put("Esp", "España");
		countries.put("Mex", "Mèxico");
		countries.put("Ven", "Venezuela");
		
		return countries;
		
		
	}
	
	@ModelAttribute("genreList")
	public List<String> genreList(){
		return Arrays.asList("Sin Especificar","Hombre", "Mujer");
	}
	
	@ModelAttribute("countryListC")
	public List<Pais> countryListC() {
		
		
		return countryS.initial_List();
	}
	
	@ModelAttribute("roleListS")
	public List<Role> roleListS(){
		return rolesS.initial_RolesList();
	}
	
	
	@ModelAttribute("rolesListString")
	public List<String> rolesListString(){
		List<String> roles = new ArrayList<>();
		
		roles.add("ROLE_USER");
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_MODERATOR");
		
		return roles;
	}
	
	@ModelAttribute("rolesMap")
	public Map<String, String> rolesMap(){
		Map<String, String> roles= new HashMap<String, String>();
		
		roles.put("ROLE_USER", "Administrador");
		roles.put("ROLE_ADMIN", "Usuario");
		roles.put("ROLE_MODERATOR","Moderador");
		
		
		return roles;
		
		
	}
	
	@GetMapping({"","/form"})
	public String form(Model model) {
		User user = new User();
		model.addAttribute("title", "Registrar Usuario");
		user.setName("Jonh");
		user.setLastname("doe");
		user.setTerms(true);
		user.setCodeIdUnique(234854);
		user.setCountry(new Pais("arg", "Argentina"));
		user.setRoles(Arrays.asList(new Role(2, "ROLE_ADMIN", "Administrador")));
		//user.setId("12.545.8-k");
		model.addAttribute("user", user);
		return "form";
	}
	
	
	
	@PostMapping("/form")
	public String getDataOfForm(@Valid User user, BindingResult result, Model model) {
		
		//uValidation.validate(u, result);
		//you can map an HTTP request to an instance of an object, sending in the parameters the instance of the object
		//model.addAttribute("title", "Datos de usuario");
		
		if (result.hasErrors()) {
			model.addAttribute("title", "Datos de usuario");
			/*
			 * custom Errors
			 * Map<String, String> errs = new HashMap<>();
			result.getFieldErrors().forEach(err->{
				errs.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			 model.addAttribute("error", errs);
			});*/
			
			//If the application has an error, the returned view will be the view form
			return "form";
		}
		
		
		return "redirect:/profile";
	}
	
	@GetMapping("/profile")
	public String profile(@SessionAttribute( name="user", required = false) User user, Model model, SessionStatus status) {
		
		if(user == null) {
			
			return "redirect:/form";
		}
		
		model.addAttribute("title", "Datos de usuario");
		
		
		status.setComplete();
		return "resultform";
	}
	
}
