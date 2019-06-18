package com.projeto.springbasic;

import com.projeto.springbasic.domain.Endereco;
import com.projeto.springbasic.domain.Estado;
import com.projeto.springbasic.domain.Pessoa;
import com.projeto.springbasic.domain.PessoaFisica;
import com.projeto.springbasic.domain.PessoaJuridica;
import com.projeto.springbasic.domain.Telefone;
import com.projeto.springbasic.repositories.EnderecoRepository;
import com.projeto.springbasic.repositories.EstadoRepository;
import com.projeto.springbasic.repositories.PessoaFisicaRepository;
import com.projeto.springbasic.repositories.PessoaJuridicaRepository;
import com.projeto.springbasic.repositories.PessoaRepository;
import com.projeto.springbasic.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class SpringbasicApplication implements CommandLineRunner {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    TelefoneRepository telefoneRepository;

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    EstadoRepository estadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbasicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Estado est1 = new Estado(null, "DISTRITO FEDERAL", "DF");

        Endereco end = new Endereco(null, 700000, "Sobradinho", "NaN", "100",est1, "NaN");

        Pessoa p1 = new Pessoa(null, "Matheus1", end);
        Pessoa p2 = new Pessoa(null, "Matheus2", end);
        Pessoa p3 = new Pessoa(null, "Matheus3", end);
        Pessoa p4 = new Pessoa(null, "Matheus4", end);
        Pessoa p5 = new Pessoa(null, "Matheus5", end);
        Pessoa p6 = new Pessoa(null, "Matheus6", end);
        Pessoa p7 = new Pessoa(null, "Matheus7", end);

        PessoaFisica pf1 = new PessoaFisica(null, "05217219114", sdf.parse("12/12/2012"), p1);

        estadoRepository.save(est1);
        enderecoRepository.save(end);
        pessoaRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
        pessoaFisicaRepository.save(pf1);



    }
}
