package com.gamesCommerce.ECommerceGames.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamesCommerce.ECommerceGames.model.Categoria;
import com.gamesCommerce.ECommerceGames.model.Produto;
import com.gamesCommerce.ECommerceGames.repository.ProdutoRepository;

@RestController
@RequestMapping ("/produtos")
@CrossOrigin ("*")
public class ProdutoController {
	
	ProdutoRepository repository;
	@GetMapping
	public ResponseEntity<List<Produto>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("{/id}") 
	public ResponseEntity<Produto> getById(@PathVariable long id)
	{
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categoriao/{catelogia}")
	public ResponseEntity<List<Produto>> GetByCategoria(@PathVariable String produto)
	{
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(produto));
	}
	@PostMapping
	public ResponseEntity<Produto> post (@RequestBody Produto Produto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto produto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable Long id) 
	{
		repository.deleteById(id);
	}
}
