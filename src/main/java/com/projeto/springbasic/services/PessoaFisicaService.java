package com.projeto.springbasic.services;

import com.projeto.springbasic.domain.PessoaFisica;
import com.projeto.springbasic.repositories.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaFisicaService {

    @Autowired
    PessoaFisicaRepository repository;

    public PessoaFisica find(Integer id){
        Optional <PessoaFisica> pessoaFisica = repository.findById(id);
        return pessoaFisica.orElse(null);
    }


}
