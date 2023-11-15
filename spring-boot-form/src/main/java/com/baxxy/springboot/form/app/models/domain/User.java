package com.baxxy.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

//import org.springframework.format.annotation.DateTimeFormat;

import com.baxxy.springboot.form.app.validators.IdRegex;
import com.baxxy.springboot.form.app.validators.RequiedF;

//import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
//import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class User {
	
	
	//@Pattern(regexp = "[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdRegex
	private String id;
	
	//@NotEmpty(message = "Campo vacio, por favor agregué un nombre ")
	private String name;
	
	@NotEmpty
	private String lastname;
	
	@RequiedF
	private String username;
	
	
	@NotEmpty
	@Size(min = 4, max = 15)
	private String password;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Min(11)
	@Max(999)
	private Integer numberCard;
	
	@NotNull
	@PastOrPresent
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	
	@NotNull
	private Pais country;
	
	@NotEmpty
	private List<Role> roles;
	
	private Boolean terms;
	
	@NotEmpty
	private String genre;
	
	private Integer codeIdUnique;
	
	public User() {
		
	}

	public User(String username, String password, String email) {

		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(Integer numberCard) {
		this.numberCard = numberCard;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Pais getCountry() {
		return country;
	}

	public void setCountry(Pais country) {
		this.country = country;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getTerms() {
		return terms;
	}

	public void setTerms(Boolean terms) {
		this.terms = terms;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getCodeIdUnique() {
		return codeIdUnique;
	}

	public void setCodeIdUnique(Integer codeIdUnique) {
		this.codeIdUnique = codeIdUnique;
	}

	
	
	
	
	
}
