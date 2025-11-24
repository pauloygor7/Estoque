package com.anm.estoque.service;

import com.anm.estoque.model.ProdutoModelo;
import com.anm.estoque.model.RespostaModelo;
import com.anm.estoque.repository.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServico {

    @Autowired
    private EstoqueRepositorio er;

    @Autowired
    private RespostaModelo rm;

    public Iterable<ProdutoModelo> listar() {
        return er.findAll();
    }

    public ProdutoModelo buscarPorId(Long id) {
        return er.findById(id).get();
    }

    public ResponseEntity<RespostaModelo> deletarProduto(Long id){
        er.deleteById(id);
        rm.setMensagem("O produto foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }

}
