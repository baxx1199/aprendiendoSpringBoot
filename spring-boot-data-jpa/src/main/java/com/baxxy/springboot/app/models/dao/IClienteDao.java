package com.baxxy.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baxxy.springboot.app.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

	/*public List<Cliente> finAll();

	public void save(Cliente cliente);

	public Cliente findOne(Long id);

	public void delete(Long id);*/
	
	/*
	 * also, we can implement a crud faster using crudRespository an interface native to spring 
	 * 
	 * in this case, this class must be extended from crudRespositor and must be empty some methods have minor differences how the findOne() method is findById()
	 * 
	 * the ClientDaoImplement class must not be implemented
	 * 
	 * */
}
