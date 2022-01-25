package com.eCommerce.Farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.eCommerce.Farmacia.model.Categoria;
import com.eCommerce.Farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{categoria}")
	public ResponseEntity<List<Categoria>> GetByCategoria(@PathVariable String categoria){
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	@PostMapping("/new") // Salva no banco de dados
	public ResponseEntity<Categoria> newCategoria(@RequestBody Categoria newCategoria) {
		return ResponseEntity.status(201).body(repository.save(newCategoria));
	}

	@PutMapping("/edit") // Edita valores no banco de dados
	public ResponseEntity<Categoria> editCategoria(@RequestBody Categoria editCategoria) {
		return ResponseEntity.status(200).body(repository.save(editCategoria));
	}

	@DeleteMapping("/delete/{id}") // Deleta linha no banco de dados por id
	public void deleteCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}

}
