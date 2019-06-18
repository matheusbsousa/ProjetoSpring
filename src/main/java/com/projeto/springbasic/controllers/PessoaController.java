package com.projeto.springbasic.controllers;


import com.projeto.springbasic.domain.Pessoa;
import com.projeto.springbasic.dto.PessoaDTO;
import com.projeto.springbasic.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> find(@PathVariable  Integer id){
        Pessoa pessoa = pessoaService.find(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @RequestMapping(method = RequestMethod.POST )
    public ResponseEntity<Void> insert(@Valid @RequestBody PessoaDTO pessoaDTO){
        Pessoa pessoa = new Pessoa(pessoaDTO);
        pessoa = pessoaService.insert(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> update(@Valid @RequestBody PessoaDTO pessoaDTO, @PathVariable Integer id){
        Pessoa pessoa = new Pessoa(pessoaDTO);
        pessoa.setId(id);
        pessoa = pessoaService.update(pessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        this.pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PessoaDTO>> findAll(){
        List<Pessoa> listPessoa = pessoaService.findAll();
        List<PessoaDTO> listPessoaDTO = listPessoa.stream().map(o-> new PessoaDTO(o)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listPessoaDTO);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<PessoaDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy){
        Page<Pessoa> listPagePessoa = pessoaService.findPage(page, linesPerPage, direction, orderBy);
        Page<PessoaDTO> listPagePessoaDTO = listPagePessoa.map(o-> new PessoaDTO(o));
        return ResponseEntity.ok().body(listPagePessoaDTO);
    }



}
