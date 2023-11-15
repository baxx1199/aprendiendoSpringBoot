package com.baxxy.springboot.di.app.models.services;


import org.springframework.stereotype.Component;

@Component("myComplicateService")

public class MyServiceComplicate implements IService {

	@Override
	public String operation() {
		
		return "Estamos implementando esta operacion atravez de la interfaz pero yo soy complejo";
	}
	
	
	//All spring components that we will register in the container must have an empty constructor method
}
