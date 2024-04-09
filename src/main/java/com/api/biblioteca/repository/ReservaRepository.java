package com.api.biblioteca.repository;

import com.api.biblioteca.model.Leitura;
import com.api.biblioteca.model.Reserva;
import com.api.biblioteca.model.ReservaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, ReservaId> {
}
