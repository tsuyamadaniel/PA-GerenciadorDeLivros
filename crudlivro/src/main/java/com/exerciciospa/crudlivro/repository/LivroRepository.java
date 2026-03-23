package com.exerciciospa.crudlivro.repository;

import com.exerciciospa.crudlivro.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}