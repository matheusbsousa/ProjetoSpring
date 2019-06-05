package com.projeto.springbasic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "PESSOA_JURIDICA")
public class PessoaJuridica  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PESSOAJURIDICA")
    private Integer id;

    @Column(name = "CNPJ")
    private String cnpj;

    @NotNull
    @OneToOne
    @JoinColumn(name = "PESSOA_ID_PESSOAJURIDICA")
    private Pessoa pessoa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaJuridica(Integer id, String cnpj, Pessoa pessoa) {
        this.id = id;
        this.cnpj = cnpj;
        this.pessoa = pessoa;
    }
}
