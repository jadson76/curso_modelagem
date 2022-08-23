package com.jadson.curso.modelagem.service;

import com.jadson.curso.modelagem.domain.Cliente;
import com.jadson.curso.modelagem.repository.ClienteRepository;
import com.jadson.curso.modelagem.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {
        Optional<Cliente> opt = repo.findById(id);
        return opt.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

    }
}
