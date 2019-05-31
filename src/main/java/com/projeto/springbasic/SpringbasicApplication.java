package com.projeto.springbasic;

import com.projeto.springbasic.domain.Pessoa;
import com.projeto.springbasic.domain.Telefone;
import com.projeto.springbasic.repositories.PessoaRepository;
import com.projeto.springbasic.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringbasicApplication implements CommandLineRunner {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    TelefoneRepository telefoneRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbasicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Pessoa p1 = new Pessoa(null,"Matheus","Barros");
        Pessoa p2 = new Pessoa(null,"Carlos","Sousa");
        Pessoa p3 = new Pessoa(null,"Luke","Skywalker");

        Telefone t1 = new Telefone(null, "061", "99999999");
        Telefone t2 = new Telefone(null, "062", "43234234");
        Telefone t3 = new Telefone(null, "063", "11111111");
        Telefone t4 = new Telefone(null, "063", "55555555");
        Telefone t5 = new Telefone(null, "062", "12121212");

        t1.setPessoa(p1);
        t2.setPessoa(p1);
        t3.setPessoa(p2);
        t4.setPessoa(p3);
        t5.setPessoa(p3);

        pessoaRepository.saveAll(Arrays.asList(p1,p2,p3));
        telefoneRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5));

    }
}
