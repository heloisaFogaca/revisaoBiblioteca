package com.api.biblioteca.model.post;

import com.api.biblioteca.model.Exemplar;
import com.api.biblioteca.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaPostDTO {
    private Exemplar exemplar;
    private Usuario usuario;
}
