package com.api.biblioteca.service;

import com.api.biblioteca.model.*;
import com.api.biblioteca.model.get.LeituraGetDTO;
import com.api.biblioteca.model.get.ReservaGetDTO;
import com.api.biblioteca.model.get.UsuarioGetDTO;
import com.api.biblioteca.model.post.LeituraPostDTO;
import com.api.biblioteca.model.post.ReservaPostDTO;
import com.api.biblioteca.model.post.UsuarioPostDTO;
import com.api.biblioteca.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper;
    private ExemplarRepository exemplarRepository;
    private ReservaRepository reservaRepository;
    private LivroRepository livroRepository;
    private LeituraRepository leituraRepository;

    public UsuarioGetDTO save(UsuarioPostDTO usuarioPostDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioPostDTO, usuario);
        usuarioRepository.save(usuario);

        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO();
        BeanUtils.copyProperties(usuario, usuarioGetDTO);
        return usuarioGetDTO;
    }

    public Usuario findOne(Long id){
        return usuarioRepository.findById(id).get();
    }

    public UsuarioGetDTO update(Long id, UsuarioPostDTO usuarioPostDTO) {
        Usuario usuario = findOne(id);
        modelMapper.map(usuarioPostDTO, usuario);
        usuarioRepository.save(usuario);
        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO();
        BeanUtils.copyProperties(usuario, usuarioGetDTO);
        return usuarioGetDTO;


    }

    public ReservaGetDTO saveReserva(Long userId, ReservaId reservaId) {
        Usuario usuario = findOne(userId);
        Reserva reserva = new Reserva();
        ReservaPostDTO reservaPostDTO = new ReservaPostDTO(exemplarRepository.findById(reservaId.getExemplarId()).get(), usuario);
        reserva.setId(new ReservaId(userId, reservaId.getExemplarId()));
        BeanUtils.copyProperties(reservaPostDTO, reserva);

        reservaRepository.save(reserva);
        ReservaGetDTO reservaGetDTO = new ReservaGetDTO(userId, reservaId.getExemplarId(), reserva.getDataReserva());

        return  reservaGetDTO;


    }

    public LeituraGetDTO saveLeitura(Long userId, Long bookId, LeituraPostDTO leituraPostDTO) {
        Usuario usuario = findOne(userId);
        Livro livro = livroRepository.findById(bookId).get();
        Leitura leitura = new Leitura();
        leitura.setUsuario(usuario);
        leitura.setLivro(livro);
        leituraRepository.save(leitura);
        LeituraGetDTO leituraGetDTO = new LeituraGetDTO(leitura.getId(), leitura.getUsuario().getId(), leitura.getLivro().getId(), leitura.getDataInicio(), leitura.getDataConclusao());

        return leituraGetDTO;
    }
}
