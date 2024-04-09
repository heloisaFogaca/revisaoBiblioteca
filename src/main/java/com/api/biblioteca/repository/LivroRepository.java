package com.api.biblioteca.repository;

import com.api.biblioteca.model.Leitura;
import com.api.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
