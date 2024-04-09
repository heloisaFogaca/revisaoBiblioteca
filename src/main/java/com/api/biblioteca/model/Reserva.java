package com.api.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_reserva")
public class Reserva {
    @EmbeddedId
    private ReservaId id;
    private LocalDateTime dataReserva = LocalDateTime.now();

    @ManyToOne
    @MapsId("usuarioId")
    private Usuario usuario;
    @ManyToOne
    @MapsId("exemplarId")
    private Exemplar exemplar;

}
