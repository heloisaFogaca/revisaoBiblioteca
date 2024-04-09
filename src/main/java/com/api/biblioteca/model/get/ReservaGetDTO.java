package com.api.biblioteca.model.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaGetDTO {
    private Long exemplarId;
    private Long usuarioId;
    private LocalDateTime dataReserva;
}
