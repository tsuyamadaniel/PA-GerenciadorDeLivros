package com.exerciciospa.crudlivro.controller;

import com.exerciciospa.crudlivro.entity.Livro;
import com.exerciciospa.crudlivro.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
        return ResponseEntity.status(201).body(service.salvar(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}