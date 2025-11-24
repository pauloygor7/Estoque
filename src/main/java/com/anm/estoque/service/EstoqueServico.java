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

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao){
        if (pm.getNome().equals("")) {
            rm.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getModelo().equals("")) {
            rm.setMensagem("O modelo do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getDescricao().equals("")) {
            rm.setMensagem("A descrição do produto é obrigatória!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getPreco() == null) {
            rm.setMensagem("O preço do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }

        if (acao.equals("cadastrar")) {
            return new ResponseEntity<ProdutoModelo>(HttpStatus.CREATED);
        } else{
            return new ResponseEntity<ProdutoModelo>(er.save(pm), HttpStatus.OK);
        }
    }

}
