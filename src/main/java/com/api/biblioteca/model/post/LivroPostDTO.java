package com.api.biblioteca.model.post;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class LivroPostDTO {
    private String titulo;
    private String autor;
    private String genero;
    private Integer anoPublicacao;

}
