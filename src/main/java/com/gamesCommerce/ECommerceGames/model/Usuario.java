package com.gamesCommerce.ECommerceGames.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Nome", nullable = false, length = 150)
	@Size(min = 1, max = 100) 
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	private String senha;
	
}
