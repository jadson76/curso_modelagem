package com.jadson.curso.modelagem.repository;

import com.jadson.curso.modelagem.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
