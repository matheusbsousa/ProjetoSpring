package com.projeto.springbasic.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PESSOA_FISICA")
public class PessoaFisica implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PESSOAFISICA")
    private Integer id;

    @Column(name = "CPF")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PESSOA_ID_PESSOAFISICA")
    private Pessoa pessoa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaFisica(Integer id, String cpf, Date dataNascimento, Pessoa pessoa) {
        this.id = id;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.pessoa = pessoa;
    }
}
