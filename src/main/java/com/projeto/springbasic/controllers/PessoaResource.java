package com.projeto.springbasic.controllers;


import com.projeto.springbasic.domain.Pessoa;
import com.projeto.springbasic.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    PessoaService pessoaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable  Integer id){
        Pessoa pessoa = pessoaService.find(id);

        return ResponseEntity.ok().body(pessoa);
    }

}
