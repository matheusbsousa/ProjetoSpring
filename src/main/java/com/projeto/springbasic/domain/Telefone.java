package com.projeto.springbasic.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_TELEFONE")
    private Integer id;

    @Column(name = "DDD")
    private String ddd;

    @Column(name = "NUMERO")
    private String numero;

    @JsonManagedReference
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;

    public Telefone() {
    }

    public Telefone(Integer id, String ddd, String numero) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
