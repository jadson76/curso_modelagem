package com.jadson.curso.modelagem.resources;

import com.jadson.curso.modelagem.domain.Categoria;
import com.jadson.curso.modelagem.repository.CategoriaRepository;
import com.jadson.curso.modelagem.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar() {
        Categoria cat1 = new Categoria(1,"Informática");
        Categoria cat2 = new Categoria(2, "Escritorio");
        return Arrays.asList(cat1,cat2);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Categoria> find(@PathVariable Integer id) {
        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

}
