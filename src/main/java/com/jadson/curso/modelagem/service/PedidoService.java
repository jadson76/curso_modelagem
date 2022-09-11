package com.jadson.curso.modelagem.service;

import com.jadson.curso.modelagem.domain.Pedido;
import com.jadson.curso.modelagem.repository.PedidoRepository;
import com.jadson.curso.modelagem.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {
        Optional<Pedido> opt = repo.findById(id);
        return opt.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));

    }
}
