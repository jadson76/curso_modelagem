package com.jadson.curso.modelagem.service;

import com.jadson.curso.modelagem.domain.Categoria;
import com.jadson.curso.modelagem.repository.CategoriaRepository;
import com.jadson.curso.modelagem.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> opt = repo.findById(id);
        return opt.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));

    }
}
