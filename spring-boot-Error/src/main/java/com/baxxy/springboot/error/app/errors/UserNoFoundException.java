package com.baxxy.springboot.error.app.errors;

public class UserNoFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNoFoundException(String id) {
		super("Usuario con UD: " .concat(id).concat(" no encontrado"));
		
	}

	
	
}
