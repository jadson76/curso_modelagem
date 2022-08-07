package com.jadson.curso.modelagem.resources;

import com.jadson.curso.modelagem.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar() {
        Categoria cat1 = new Categoria(1,"Informática");
        Categoria cat2 = new Categoria(2, "Escritorio");
        List<Categoria> lista = Arrays.asList(cat1,cat2);
        return lista;
    }

}
