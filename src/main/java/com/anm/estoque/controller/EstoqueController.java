package com.anm.estoque.controller;

import com.anm.estoque.model.ProdutoModelo;
import com.anm.estoque.model.RespostaModelo;
import com.anm.estoque.service.EstoqueServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> deletarProduto(@PathVariable Long id) {
        return es.deletarProduto(id);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoModelo pm) {
        return es.cadastrarAlterar(pm, "cadastrar");
    }
}
