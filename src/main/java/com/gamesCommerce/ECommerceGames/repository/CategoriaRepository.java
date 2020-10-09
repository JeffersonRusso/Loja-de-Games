package com.gamesCommerce.ECommerceGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamesCommerce.ECommerceGames.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public List<Categoria> findAllByTituloContainingIgnoreCase ( String t);

}
