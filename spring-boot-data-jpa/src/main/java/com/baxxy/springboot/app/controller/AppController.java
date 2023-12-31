package com.baxxy.springboot.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.baxxy.springboot.app.models.dao.IClienteDao;
import com.baxxy.springboot.app.models.entity.Cliente;
import com.baxxy.springboot.app.service.IClienteService;
import com.baxxy.springboot.app.utils.paginator.PageRender;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("cliente")
public class AppController {

	@Autowired
	private IClienteService iclienteService;

	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		dateformat.setLenient(true);

		wdb.registerCustomEditor(Date.class, new CustomDateEditor(dateformat, false));
	}

	@GetMapping("/lista")
	public String listar(@RequestParam (name="page", defaultValue = "0") int page,Model model) {
		
		Pageable requestPage = PageRequest.of(page, 5);
		Page<Cliente> clients = iclienteService.findAll(requestPage);
		
		PageRender<Cliente> paginator = new PageRender<>("/lista", clients);
		
		model.addAttribute("title", "Listado de clientes");
		model.addAttribute("listaClientes", clients);
		model.addAttribute("page",paginator);

		return "clientes";
	}

	@GetMapping("/form")
	public String crear(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("title", "formulario de cliente");
		model.put("cliente", cliente);

		return "form";

	}

	@PostMapping("/form")
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model,@RequestParam("profilePhotoIn") MultipartFile profilePhoto , RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("title", "formulario de cliente");
			flash.addFlashAttribute("error","Se produjo un error al guardar el cliente.");
			return "form";
		}
		
		if(!profilePhoto.isEmpty()){
			Path resourcePath = Paths.get("src//main//resource//static/uploads");
			String rootPath = resourcePath.toFile().getAbsolutePath();
			try {
				byte [] bytes = profilePhoto.getBytes();
				Path fullPath = Paths.get(rootPath+"//"+ profilePhoto.getOriginalFilename());
				Files.write(fullPath, bytes);
				flash.addFlashAttribute("success", "Foto de perfil cargada con exito.");
				cliente.setProfilePhoto(profilePhoto.getOriginalFilename());
			} catch (IOException e) {
				flash.addFlashAttribute("info", "No se pudo cargar las foto de perfil.");
				
				
				e.printStackTrace();
			}
		}
		
		String message = (cliente.getId()!=null) ?  "Cliente modificado con exito.":"Cliente se guardo exitosamente.";
		
		iclienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", message);
		return "redirect:/lista";
	}

	@GetMapping("/form/{id}")
	public String findOne(@PathVariable(value = "id") Long id, Map<String, Object> model,RedirectAttributes flash) {

		Cliente cliente = null;

		if (id > 0) {
			cliente = iclienteService.findOne(id);
			if(cliente == null) {
				flash.addFlashAttribute("error","El cliente no existe en la base de datos.");
				return "redirect:/lista";
			}
		} else {
			flash.addFlashAttribute("error","Id de cliente no puede ser 0.");
			return "redirect:/lista";
		}

		model.put("title", "Editar cliente");
		model.put("cliente", cliente);

		return "form";

	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			iclienteService.delete(id);
			flash.addFlashAttribute("success", "El cliente fue eliminado con exito.");
		}

		return "redirect:/lista";
	}

}
