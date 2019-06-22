package com.projeto.springbasic.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.springbasic.dto.PessoaDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PESSOA")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();

    @JoinColumn(name = "PESSOA_ID_ENDERECO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Endereco endereco;

    public Pessoa(Integer id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Pessoa() {
    }

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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Pessoa(PessoaDTO pessoaDTO){
        this.setId(pessoaDTO.getId());
        this.setNome(pessoaDTO.getNome());
        this.setEndereco(pessoaDTO.getEndereco());

        if(Objects.nonNull(pessoaDTO.getEndereco()) && Objects.nonNull(pessoaDTO.getEndereco().getId())){
        }
    }
}
