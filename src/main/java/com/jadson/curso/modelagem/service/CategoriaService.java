package com.jadson.curso.modelagem.service;

import com.jadson.curso.modelagem.domain.Categoria;
import com.jadson.curso.modelagem.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        return repo.getById(id);

    }
}
