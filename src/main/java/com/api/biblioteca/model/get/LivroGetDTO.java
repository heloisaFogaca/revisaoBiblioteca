package com.api.biblioteca.model.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroGetDTO {
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private Integer anoPublicacao;
}
