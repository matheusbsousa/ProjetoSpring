package com.projeto.springbasic.services;

import com.projeto.springbasic.domain.Pessoa;
import com.projeto.springbasic.repositories.PessoaRepository;
import com.projeto.springbasic.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public Pessoa find(Integer id){

        Optional<Pessoa> pessoa = repository.findById(id);
        return pessoa.orElseThrow(()-> new ObjectNotFoundException( "Objeto não encontrado ! Id: " + id + ", Tipo, " + Pessoa.class.getName()));
    }

    public Pessoa insert(Pessoa pessoa){
        pessoa.setId(null);
        return repository.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa){
        this.find(pessoa.getId());
        return repository.save(pessoa);
    }

    public void delete(Integer id){
        Pessoa pessoa = this.find(id);
        repository.delete(pessoa);
    }

    public List<Pessoa> findAll(){
        return  repository.findAll();
    }

    public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String direction, String orderBy ){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        return repository.findAll(pageRequest);
    }

}
