package com.gamesCommerce.ECommerceGames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Aluno, Long> {
	
	public <List<Aluno>> getAllContainNomeIgnoreUpperCase(String name);

}
