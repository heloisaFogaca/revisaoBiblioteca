package com.api.biblioteca.controller;

import com.api.biblioteca.model.Reserva;
import com.api.biblioteca.model.ReservaId;
import com.api.biblioteca.model.get.LeituraGetDTO;
import com.api.biblioteca.model.get.ReservaGetDTO;
import com.api.biblioteca.model.get.UsuarioGetDTO;
import com.api.biblioteca.model.post.LeituraPostDTO;
import com.api.biblioteca.model.post.ReservaPostDTO;
import com.api.biblioteca.model.post.UsuarioPostDTO;
import com.api.biblioteca.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsuarioController {
    private UsuarioService usuarioService;

    @PostMapping
    private ResponseEntity<UsuarioGetDTO> insert(@RequestBody UsuarioPostDTO usuarioPostDTO) {
        try {
            return ResponseEntity.ok(usuarioService.save(usuarioPostDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{userId}")
    private ResponseEntity<ReservaGetDTO> insertReserva(@PathVariable Long userId, @RequestBody ReservaId reservaId){
        try {
            return ResponseEntity.ok(usuarioService.saveReserva(userId, reservaId));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{userId}/books/{bookId}/readings")
    private ResponseEntity<LeituraGetDTO> insertLeitura(@PathVariable Long userId, @PathVariable Long bookId, @RequestBody LeituraPostDTO leituraPostDTO){
        try {
            return ResponseEntity.ok(usuarioService.saveLeitura(userId,bookId, leituraPostDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<UsuarioGetDTO> update(@PathVariable Long id, @RequestBody UsuarioPostDTO usuarioPostDTO){
        try {
            return ResponseEntity.ok(usuarioService.update(id, usuarioPostDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
