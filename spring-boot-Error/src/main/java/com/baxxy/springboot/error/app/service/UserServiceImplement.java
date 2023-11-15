package com.baxxy.springboot.error.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baxxy.springboot.error.app.models.User;


@Service
public class UserServiceImplement implements UserService {

	public List<User> users;
	
	
	public UserServiceImplement() {
		users= new ArrayList<>();
		
		users.add(new User(1, "pedro", "dev"));
		users.add(new User(2, "juan", "cocinero"));
		users.add(new User(3, "laura", "R.H"));
		users.add(new User(4, "yeni", "dev"));
		users.add(new User(5, "felipe", "Arquitecto"));
		users.add(new User(6, "camila", "contador"));
		users.add(new User(7, "caro", "contador"));
		users.add(new User(8, "tony", "empresario"));
		users.add(new User(9, "peter", "fotografo"));
	}
	
	@Override
	public List<User> listar() {
		
		return this.users;
	}

	@Override
	public User search(Integer id) {
		User userFind= null;
		
		for (User user : this.users) {
			if(user.getId().equals(id)) {
				userFind = user;
			}
		}
		
		return userFind;
	}

	@Override
	public Optional<User> searchWithOptional(Integer id) {
		User userFind= this.search(id);
		return Optional.ofNullable(userFind);
	}

}
