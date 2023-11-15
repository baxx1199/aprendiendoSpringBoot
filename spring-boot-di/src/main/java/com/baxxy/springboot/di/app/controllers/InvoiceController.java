package com.baxxy.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baxxy.springboot.di.app.models.domains.Invoice;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private Invoice invoice;
	
	@GetMapping({"/see", "", "/"})
	public String watchInvoice(Model model) {
		
		model.addAttribute("inv", invoice );
		
		model.addAttribute("title", "Factura con inyeccion de dependencias");
		return "seeInvoice";
	}
}
