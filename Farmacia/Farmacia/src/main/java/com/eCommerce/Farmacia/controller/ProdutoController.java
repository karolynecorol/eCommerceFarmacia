package com.eCommerce.Farmacia.controller;

import java.util.List;

import com.eCommerce.Farmacia.model.Produto;
import com.eCommerce.Farmacia.repository.ProdutoRepository;

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

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/all")
    public ResponseEntity<List<Produto>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> GetById(@PathVariable long id) {
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{produto}")
    public ResponseEntity<List<Produto>> GetByProduto (@PathVariable String nome) {
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping("/new")
    public ResponseEntity<Produto> newProduto (@RequestBody Produto newProduto) {
        return ResponseEntity.status(201).body(repository.save(newProduto));
    }

    @PutMapping("/edit")
    public ResponseEntity<Produto> editProduto (@RequestBody Produto editProduto) {
        return ResponseEntity.status(200).body(repository.save(editProduto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduto (@PathVariable long id) {
        repository.deleteById(id);
    }
}
