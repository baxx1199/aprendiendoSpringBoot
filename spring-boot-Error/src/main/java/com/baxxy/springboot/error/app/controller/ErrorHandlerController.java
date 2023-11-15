package com.baxxy.springboot.error.app.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.baxxy.springboot.error.app.errors.UserNoFoundException;

@ControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticEx(ArithmeticException ex, Model model) {
		
		model.addAttribute("title", "Error aritmetco");
		model.addAttribute("message", "Se ha producido un error al intentar dividir un numero entre cero");
		//model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/arithmetic";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatEx(NumberFormatException ex, Model model) {
		
		model.addAttribute("title", "Error: conversion de texto numero");
		model.addAttribute("message", "Se ha producido un error al intentar convertir una cadena de texto en numeros");
		//model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/number-format";
	}
	
	@ExceptionHandler(UserNoFoundException.class)
	public String userNoFoundEx(UserNoFoundException ex, Model model) {
		
		model.addAttribute("error", "Error de busqueda en el sistema");
		//model.addAttribute("message", "Se ha producido un error al intentar convertir una cadena de texto en numeros");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/500";
	}
}
