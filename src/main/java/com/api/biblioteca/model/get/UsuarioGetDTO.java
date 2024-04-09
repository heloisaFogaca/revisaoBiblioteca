package com.api.biblioteca.model.get;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGetDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;

}
