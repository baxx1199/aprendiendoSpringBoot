package com.baxxy.springboot.di.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("mySimpleService")
@Primary
public class MyService implements IService {

	@Override
	public String operation() {
		
		return "Estamos implementando esta operacion atravez de la interfaz pero mas simple";
	}
	
	
	//All spring components that we will register in the container must have an empty constructor method
}
