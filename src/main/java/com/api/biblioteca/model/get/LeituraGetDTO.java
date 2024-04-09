package com.api.biblioteca.model.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeituraGetDTO {
    private Long id;
    private Long usuarioId;
    private Long livroId;
    private LocalDateTime dataInicio;
    private LocalDateTime dataConclusao;

}
