package com.anm.estoque.repository;

import com.anm.estoque.model.ProdutoModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepositorio extends CrudRepository<ProdutoModelo, Long> {

}
