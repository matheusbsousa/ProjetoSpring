package com.projeto.springbasic.dto;

import com.projeto.springbasic.domain.Pessoa;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class PessoaDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório!!!")
    @Length(min = 5, max = 80, message = "O tamanho do campo deve estar entre 5 e 80 caracteres")
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PessoaDTO() {
    }

    public PessoaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public PessoaDTO(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
    }
}
