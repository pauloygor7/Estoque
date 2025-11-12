package com.anm.estoque.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class EstoqueController {

    @GetMapping
    public void testeApi() {
        System.out.println("A API está funcionando!");
    }
}
