package com.api.biblioteca.model.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExemplarGetDTO {
    private Long id;
    private Long livroId;
    private String status;
    private LocalDateTime dataAquisicao;

}
