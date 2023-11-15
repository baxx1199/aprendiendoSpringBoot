package com.baxxy.springboot.error.app.service;

import java.util.List;
import java.util.Optional;

import com.baxxy.springboot.error.app.models.User;

public interface UserService {

	public List<User> listar();
	
	
	public User search(Integer id);
	public Optional< User> searchWithOptional(Integer id);
}
