package com.projeto.springbasic.repositories;

import com.projeto.springbasic.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Integer>{









}
