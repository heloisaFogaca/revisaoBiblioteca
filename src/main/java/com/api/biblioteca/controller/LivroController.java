package com.api.biblioteca.controller;

import com.api.biblioteca.model.ReservaId;
import com.api.biblioteca.model.get.ExemplarGetDTO;
import com.api.biblioteca.model.get.LivroGetDTO;
import com.api.biblioteca.model.post.ExemplarPostDTO;
import com.api.biblioteca.model.post.LivroPostDTO;
import com.api.biblioteca.service.LivroService;
import com.api.biblioteca.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class LivroController {
    private LivroService livroService;

    @PostMapping
    private ResponseEntity<LivroGetDTO> insert(@RequestBody LivroPostDTO livroPostDTO) {
        try {
            return ResponseEntity.ok(livroService.save(livroPostDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{bookId}")
    private ResponseEntity<ExemplarGetDTO> insertExemplar(@PathVariable Long bookId, @RequestBody ExemplarPostDTO exemplarPostDTO) {
        try {
            return ResponseEntity.ok(livroService.saveExemplar(bookId, exemplarPostDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<LivroGetDTO> update(@PathVariable Long id, @RequestBody LivroPostDTO livroPostDTO){
        try {
            return ResponseEntity.ok(livroService.update(id, livroPostDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
