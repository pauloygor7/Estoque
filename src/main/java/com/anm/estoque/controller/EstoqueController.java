package com.anm.estoque.controller;

import com.anm.estoque.model.ProdutoModelo;
import com.anm.estoque.service.EstoqueServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
public class EstoqueController {

    @Autowired
    private EstoqueServico es;

    @GetMapping("/")
    public void testeApi() {
        System.out.println("A API está funcionando!");
    }

    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar() {
        return es.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModelo> buscarPorId(@PathVariable Long id) {
        ProdutoModelo produto = es.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }
}
