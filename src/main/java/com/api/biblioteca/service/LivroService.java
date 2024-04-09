package com.api.biblioteca.service;

import com.api.biblioteca.model.*;
import com.api.biblioteca.model.Livro;
import com.api.biblioteca.model.get.ExemplarGetDTO;
import com.api.biblioteca.model.get.LivroGetDTO;
import com.api.biblioteca.model.get.LivroGetDTO;
import com.api.biblioteca.model.post.ExemplarPostDTO;
import com.api.biblioteca.model.post.LivroPostDTO;
import com.api.biblioteca.repository.ExemplarRepository;
import com.api.biblioteca.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@AllArgsConstructor
public class LivroService {
    private LivroRepository livroRepository;
    private ModelMapper modelMapper;
    private ExemplarRepository exemplarRepository;

    public LivroGetDTO save(LivroPostDTO livroPostDTO) {
        Livro livro = new Livro();
        BeanUtils.copyProperties(livroPostDTO, livro);
        livroRepository.save(livro);

        LivroGetDTO livroGetDTO = new LivroGetDTO();
        BeanUtils.copyProperties(livro, livroGetDTO);
        return livroGetDTO;
    }

    public Livro findOne(Long id){
        return livroRepository.findById(id).get();
    }

    public LivroGetDTO update(Long id, LivroPostDTO livroPostDTO) {
        Livro livro = findOne(id);
        modelMapper.map(livroPostDTO, livro);
        livroRepository.save(livro);
        LivroGetDTO livroGetDTO = new LivroGetDTO();
        BeanUtils.copyProperties(livro, livroGetDTO);
        return livroGetDTO;
    }

    public ExemplarGetDTO saveExemplar(Long bookId, ExemplarPostDTO exemplarPostDTO) {
        Livro livro = findOne(bookId);
        Exemplar exemplar = new Exemplar();
        exemplar.setLivro(livro);
        exemplar.setStatus(Status.DISPONIVEL);
        exemplarRepository.save(exemplar);
        ExemplarGetDTO exemplarGetDTO = new ExemplarGetDTO();
        BeanUtils.copyProperties(exemplar, exemplarGetDTO);
        return exemplarGetDTO;
    }
}
