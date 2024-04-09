package com.api.biblioteca.model.post;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UsuarioPostDTO {
    private String nome;
    private String email;
    private String senha;
}

