package com.projeto.springbasic.services;

import com.projeto.springbasic.domain.Pessoa;
import com.projeto.springbasic.repositories.PessoaRepository;
import com.projeto.springbasic.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public Pessoa find(Integer id){

        Optional<Pessoa> pessoa = repository.findById(id);
        return pessoa.orElseThrow(()-> new ObjectNotFoundException( "Objeto não encontrado ! Id: " + id + ", Tipo, " + Pessoa.class.getName()));
    }
}
