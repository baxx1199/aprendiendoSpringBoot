package com.baxxy.springboot.di.app.models.domains;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
public class Invoice {
	
	@Value("${text.invoice.desc}")
	private String description;
	
	@Autowired
	private Client client;
	
	@Autowired(required = true)
	private List<ItemInvoice> items;
	
	@PostConstruct
	public void initialComp() {
		client.setName(client.getName().concat(" ").concat(" Julian "));
		description = description.concat(" ").concat("de ").concat(client.getName());
	}
	
	@PreDestroy
	public void destrucComp() {
		System.out.println("La factra se destruyo "+ description);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<ItemInvoice> getItems() {
		
		return items;
	}
	public void setItems(List<ItemInvoice> items) {
		this.items = items;
	}
	
	
}
