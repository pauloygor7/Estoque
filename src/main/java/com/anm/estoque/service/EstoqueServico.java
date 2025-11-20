package com.anm.estoque.service;

import com.anm.estoque.model.ProdutoModelo;
import com.anm.estoque.repository.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServico {

    @Autowired
    private EstoqueRepositorio er;

    public Iterable<ProdutoModelo> listar() {
        return er.findAll();
    }

    public ProdutoModelo buscarPorId(Long id) {
        return er.findById(id).get();
    }

}
